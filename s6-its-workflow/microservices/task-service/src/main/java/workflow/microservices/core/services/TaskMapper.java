package workflow.microservices.core.services;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import workflow.api.task.Task;
import workflow.microservices.core.persistence.TaskEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    Task entityToApi(TaskEntity entity);
    @Mappings({
        @Mapping(target = "id", ignore = true), @Mapping(target = "version", ignore = true)
    })
    TaskEntity apiToEntity(Task api);

    List<Task> entityListToApiList(List<TaskEntity> entity);

    List<TaskEntity> apiListToEntityList(List<Task> api);
}
