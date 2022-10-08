package workflow.microservices.core.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProjectRepository extends MongoRepository<ProjectEntity, String> {
    Optional<ProjectEntity> findByProjectId(long projectId);
}
