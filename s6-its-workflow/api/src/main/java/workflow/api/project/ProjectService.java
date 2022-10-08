package workflow.api.project;

import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ProjectService {

    @GetMapping(
        value = "/project",
        produces = "application/json")
    List<Project> getAllProjects();

    @GetMapping(
        value = "/project/{projectId}",
        produces = "application/json")
    Project getProject(@PathVariable long projectId);

    @PostMapping(
        value    = "/project",
        consumes = "application/json",
        produces = "application/json")
    Project createProject(@RequestBody Project body);

    @PutMapping(
        value = "/project/{projectId}",
        consumes = "application/json",
        produces = "application/json")
    Project updateProject(@RequestBody Project body);

    @DeleteMapping(value = "/project/{projectId}")
    void deleteProject(@PathVariable long projectId);
}
