package ru.gb.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.gb.aspect.TrackUserAction;
import ru.gb.model.Task;
import ru.gb.model.TaskStatus;
import ru.gb.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    @TrackUserAction
    public List<Task> getAllTask(){
        return taskService.getAllTasks();
    }

    @PostMapping
    public Task addTask(@RequestBody Task task){
        return taskService.addTask(task);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status){
        return taskService.findTasksByStatus(status);
    }

    @PutMapping("/{id}")
    public void updateTaskStatus(@PathVariable Long id, @RequestParam TaskStatus taskStatus){
        taskService.changeTaskStatusByID(id, taskStatus);
    }

    @DeleteMapping("/{id}")
    @TrackUserAction
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTaskByID(id);
    }
}
