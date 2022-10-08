package workflow.microservices.core.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tasks")
public class TaskEntity {

    @Id private String id;
    @Version private Integer version;
    @Indexed(unique = true)
    private long taskId;

    private String title;
    private String description;
    private long projectId;
    private String status;
    private long assigneeId;
    private long createdBy;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdTime = LocalDateTime.now();

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime deadline;

    public TaskEntity() {}

    public TaskEntity(long taskId, String title, String description, long projectId, String status, long assigneeId, long createdBy, LocalDateTime deadline) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.projectId = projectId;
        this.status = status;
        this.assigneeId = assigneeId;
        this.createdBy = createdBy;
        this.deadline = deadline;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public long getTaskId() { return taskId; }

    public void setTaskId(long taskId) { this.taskId = taskId; }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public long getProjectId() { return projectId; }

    public void setProjectId(int projectId) { this.projectId = projectId; }

    public String getStatus() { return status; }

    public void setStatus(String status) { this.status = status; }

    public long getAssigneeId() { return assigneeId; }

    public void setAssigneeId(long assigneeId) { this.assigneeId = assigneeId; }

    public long getCreatedBy() { return createdBy; }

    public void setCreatedBy(long createdBy) { this.createdBy = createdBy; }

    public LocalDateTime getCreatedTime() { return createdTime; }

    public LocalDateTime getDeadline() { return deadline; }

    public void setDeadline(LocalDateTime deadline) { this.deadline = deadline; }
}
