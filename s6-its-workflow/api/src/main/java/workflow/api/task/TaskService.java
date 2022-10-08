package workflow.api.task;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TaskService {

    @GetMapping(
        value = "/task/{taskId}",
        produces = "application/json")
    Task getTask(@PathVariable long taskId);

    @GetMapping(
        value = "/task/by-project/{projectId}",
        produces = "application/json")
    List<Task> getTasksByProjectId(@PathVariable long projectId);

    @PostMapping(
        value    = "/task",
        consumes = "application/json",
        produces = "application/json")
    Task createTask(@RequestBody Task body);

    @PutMapping(
        value = "/task/{taskId}",
        consumes = "application/json",
        produces = "application/json")
    Task updateTask(@RequestBody Task body);

    @DeleteMapping(value = "/task/{taskId}")
    void deleteTask(@PathVariable long taskId);
}
