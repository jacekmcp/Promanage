package pl.project.promanage.task;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.project.promanage.project.Project;
import pl.project.promanage.project.ProjectService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
//@RequestMapping("/{user}/projects/{project}/task")
public class TaskController {


    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/project-tasks")
    public List<Task> getAllTasks2(){
        return taskService.getAllTasks2();
    }

    @GetMapping("/projects/{project}/tasks")
    public List<Task> getAllTasksForProject(@PathVariable("project") Long projectId){
        return taskService.getAllTasksForProject(projectId);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id){
        return taskService.getTask(id);
    }

    @PutMapping("/tasks/{id}")
    public void updateTask(@RequestBody Task task, @PathVariable Long id){
        taskService.updateTask(task);
    }

    @PostMapping("/tasks")
    public void createTask(@RequestBody Task task){
        taskService.addTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

}
