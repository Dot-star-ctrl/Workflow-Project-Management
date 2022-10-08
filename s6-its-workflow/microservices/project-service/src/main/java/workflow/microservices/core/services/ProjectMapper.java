package workflow.microservices.core.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import workflow.api.project.Project;
import workflow.microservices.core.persistence.ProjectEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    Project entityToApi(ProjectEntity entity);
    @Mappings({
        @Mapping(target = "id", ignore = true), @Mapping(target = "version", ignore = true)
    })
    ProjectEntity apiToEntity(Project api);

    List<Project> entityListToApiList(List<ProjectEntity> entity);

    List<ProjectEntity> apiListToEntityList(List<Project> api);
}

