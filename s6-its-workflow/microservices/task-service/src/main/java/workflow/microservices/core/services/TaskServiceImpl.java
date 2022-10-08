package workflow.microservices.core.services;

import com.mongodb.DuplicateKeyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import workflow.api.task.Task;
import workflow.api.task.TaskService;
import workflow.microservices.core.persistence.TaskEntity;
import workflow.microservices.core.persistence.TaskRepository;
import workflow.util.http.exceptions.InvalidInputException;
import workflow.util.http.exceptions.NotFoundException;
import workflow.util.message_configuration.MessageConfig;
import workflow.util.message_configuration.models.ProjectMessage;

import java.util.List;

@RestController
public class TaskServiceImpl implements TaskService {

    private static final Logger LOG = LoggerFactory.getLogger(TaskServiceImpl.class);

    private final TaskRepository repository;

    private final TaskMapper taskMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository repository, TaskMapper taskMapper) {
        this.repository = repository;
        this.taskMapper = taskMapper;
    }

    @Override
    public Task getTask(long taskId) {

        if(taskId < 1) {
            throw new InvalidInputException("Invalid taskId: " + taskId);
        }

        TaskEntity entity = repository.findByTaskId(taskId)
            .orElseThrow(() -> new NotFoundException("No task found for taskId: " + taskId));

        Task response = taskMapper.entityToApi(entity);
        LOG.debug("getTask: found taskId: {}", response.getTaskId());

        return response;
    }

    @Override
    public List<Task> getTasksByProjectId(long projectId) {
        if(projectId < 1) {
            throw new InvalidInputException("Invalid projectId: " + projectId);
        }

        List<TaskEntity> entityList = repository.findByProjectId(projectId);
        List<Task> list = taskMapper.entityListToApiList(entityList);

        LOG.debug("getTasksByProjectId: response size: {}", list.size());

        return list;
    }

    @Override
    public Task createTask(Task body) {
        try {
            TaskEntity entity = taskMapper.apiToEntity(body);
            TaskEntity newEntity = repository.save(entity);

            LOG.debug("createTask: entity created for taskId: {}", body.getTaskId());
            return taskMapper.entityToApi(newEntity);

        } catch (DuplicateKeyException dke) {
            throw new InvalidInputException("Duplicate key, Task Id: " + body.getTaskId());
        }
    }

    @Override
    public Task updateTask(Task task) {

        if(task == null) {
            throw new InvalidInputException("Invalid task: " + task);
        }
        TaskEntity entity = repository.findByTaskId(task.getTaskId())
            .orElseThrow(() -> new NotFoundException("No task found for taskId: " + task.getTaskId()));

        entity.setTitle(task.getTitle());
        entity.setDescription(task.getDescription());
        entity.setStatus(task.getStatus());
        entity.setAssigneeId(task.getAssigneeId());
        entity.setCreatedBy(task.getCreatedBy());
        entity.setDeadline(task.getDeadline());
        final TaskEntity updatedTask = repository.save(entity);
        return taskMapper.entityToApi(updatedTask);
    }

    @Override
    public void deleteTask(long taskId) {
        TaskEntity entity = repository.findByTaskId(taskId)
            .orElseThrow(() -> new NotFoundException("No task found for taskId: " + taskId));

        LOG.debug("deleteTask: tries to delete an entity with taskId: {}", taskId);
        repository.findByTaskId(taskId).ifPresent(e -> repository.delete(e));
    }

    @RabbitListener(containerFactory="myRabbitListenerContainerFactory", queues= MessageConfig.QUEUE)
    public void deleteAllTasksByProjectId(ProjectMessage msg) {

        List<Task> tasks = getTasksByProjectId(msg.getProjectId());

        if(tasks == null) {
            throw new InvalidInputException("No tasks related to project with id: " + msg.getProjectId());
        }

        LOG.debug("deleteAllTasksByProjectId: deleted all tasks for projectId: {}", msg.getProjectId());
        repository.deleteAll(repository.findByProjectId(msg.getProjectId()));
    }
}



