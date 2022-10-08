package workflow.microservices.core.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.mongodb.DuplicateKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import workflow.api.project.Project;
import workflow.api.project.ProjectService;
import workflow.microservices.core.persistence.ProjectEntity;
import workflow.microservices.core.persistence.ProjectRepository;
import workflow.util.http.ServiceUtil;
import workflow.util.http.exceptions.InvalidInputException;
import workflow.util.http.exceptions.NotFoundException;
import workflow.util.message_configuration.MessageConfig;
import workflow.util.message_configuration.models.ProjectMessage;

import java.util.List;

@RestController
public class ProjectServiceImpl implements ProjectService {

    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);
    private RabbitTemplate template;

    private final ProjectRepository repository;
    private final ServiceUtil serviceUtil;
    private final ProjectMapper projectMapper;
    @Autowired
    public ProjectServiceImpl(ProjectRepository repository, ProjectMapper projectMapper, ServiceUtil serviceUtil) {
        this.repository = repository;
        this.projectMapper = projectMapper;
        this.serviceUtil = serviceUtil;

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("electrify");
        connectionFactory.setHost("workflow-rabbit");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/");
        ObjectMapper mapper =
            new ObjectMapper()
                .registerModule(new ParameterNamesModule())
                .registerModule(new Jdk8Module())
                .registerModule(new JavaTimeModule());
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter(mapper));

        this.template = rabbitTemplate;
    }

    @Override
    public List<Project> getAllProjects() {

        return projectMapper.entityListToApiList(repository.findAll());
    }

    @Override
    public Project getProject(long projectId) {

        if(projectId < 1) {
            throw new InvalidInputException("Invalid projectId: " + projectId);
        }

        ProjectEntity entity = repository.findByProjectId(projectId)
            .orElseThrow(() -> new NotFoundException("No project found for projectId: " + projectId));

        Project response = projectMapper.entityToApi(entity);
        LOG.debug("getProject: found projectId: {}", response.getProjectId());

        return response;
    }

    @Override
    public Project createProject(Project body) {
        try {
            ProjectEntity entity = projectMapper.apiToEntity(body);
            ProjectEntity newEntity = repository.save(entity);

            LOG.debug("createProject: entity created for projectId: {}", body.getProjectId());
            return projectMapper.entityToApi(newEntity);

        } catch (DuplicateKeyException dke) {
            throw new InvalidInputException("Duplicate key, Project Id: " + body.getProjectId());
        }
    }

    @Override
    public Project updateProject(Project project) {

        if(project == null) {
            throw new InvalidInputException("Invalid project: " + project);
        }
        ProjectEntity entity = repository.findByProjectId(project.getProjectId())
            .orElseThrow(() -> new NotFoundException("No project found for projectId: " + project.getProjectId()));

        entity.setTitle(project.getTitle());
        entity.setDescription(project.getDescription());
        entity.setManagerId(project.getManagerId());
        entity.setWorkspaceId(project.getWorkspaceId());
        entity.setStatus(project.getStatus());
        final ProjectEntity updatedProject = repository.save(entity);
        return projectMapper.entityToApi(updatedProject);
    }

    @Override
    public void deleteProject(long projectId) {
        ProjectEntity entity = repository.findByProjectId(projectId)
        .orElseThrow(() -> new NotFoundException("No project found for projectId: " + projectId));

        ProjectMessage deleteTasksMsg = new ProjectMessage("deleteTasks", projectId);
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, deleteTasksMsg);

        LOG.debug("deleteProject: tries to delete an entity with projectId: {}", projectId);
        repository.findByProjectId(projectId).ifPresent(e -> repository.delete(e));
    }
}



