package workflow.microservices.core.persistence;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

//this is annotation is used to mark the
//class as an entity class used for MongoDB, that is, mapped to a collection in
//MongoDB
@Document(collection = "projects")
//@CompoundIndex(name = "wsp-mng-prj-id", unique = true, def = "{'workspaceId': 1, 'projectId' : 1}")
//@CompoundIndex(name = "mng-prj-id", unique = true, def = "{'managerId': 1, 'projectId': 1}" )
public class ProjectEntity {

    @Id private String id;
    @Version private Integer version;
    @Indexed(unique = true)
    private long projectId;

    private String title;
    private String description;
    private long managerId;
    private long workspaceId;
    private String status;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime createdTime = LocalDateTime.now();

    public ProjectEntity() {}

    public ProjectEntity(long projectId, String title, String description, long manager_Id, long workspaceId, String status) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.managerId = manager_Id;
        this.workspaceId = workspaceId;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public long getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(long workspaceId) {
        this.workspaceId = workspaceId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }
}
