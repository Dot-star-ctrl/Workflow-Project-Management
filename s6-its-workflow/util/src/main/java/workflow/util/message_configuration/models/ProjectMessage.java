package workflow.util.message_configuration.models;

import java.io.Serializable;

public class ProjectMessage implements Serializable {

    private final String message; //e.g. "delete tasks"
    private final long projectId; //e.g. 1

    public ProjectMessage() {
        this.message = null;
        this.projectId = 0;
    }

    public ProjectMessage(String message, long projectId) {
        this.message = message;
        this.projectId = projectId;
    }

    public String getMessage() {
        return message;
    }

    public long getProjectId() {
        return projectId;
    }
}
