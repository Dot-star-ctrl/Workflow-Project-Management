package workflow.microservices.core.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends MongoRepository<TaskEntity, String> {

    Optional<TaskEntity> findByTaskId(long taskId);

    List<TaskEntity> findByProjectId(long projectId);
}
