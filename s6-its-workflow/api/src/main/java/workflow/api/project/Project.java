package workflow.api.project;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class Project {
    private long projectId;
    private String title;
    private String description;
    private long managerId;
    private long workspaceId;
    private String status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdTime = LocalDateTime.now();

    public Project() {
        projectId = 0;
        this.title = null;
        this.description = null;
        this.managerId = 0;
        this.workspaceId = 0;
        this.status = null;
    }

    public Project(long projectId, String title, String description, long manager_Id, long workspaceId, String status) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.managerId = manager_Id;
        this.workspaceId = workspaceId;
        this.status = status;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId= projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getManagerId() {
        return managerId;
    }

    public void setManagerId(long manager_Id) {
        this.managerId = manager_Id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getWorkspaceId() { return workspaceId; }

    public void setWorkspaceId(long workspaceId) { this.workspaceId = workspaceId; }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
