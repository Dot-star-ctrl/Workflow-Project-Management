package workflow.api.task;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Task {
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

    public Task() {
        taskId = 0;
        title = null;
        description = null;
        projectId = 0;
        status = null;
        assigneeId = 0;
        createdBy = 0;
        this.createdTime = null;
        this.deadline = null;
    }

    public Task(long taskId, String title, String description, long projectId, String status, long assigneeId, long createdBy, LocalDateTime deadline) {
        this.taskId = taskId;
        this.title = title;
        this.description = description;
        this.projectId = projectId;
        this.status = status;
        this.assigneeId = assigneeId;
        this.createdBy = createdBy;
        this.deadline = deadline;
    }

    public long getTaskId() { return taskId; }

    public void setTaskId(long taskId) { this.taskId = taskId; }

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
