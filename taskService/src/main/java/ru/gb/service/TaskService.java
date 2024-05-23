package ru.gb.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.gb.model.Task;
import ru.gb.model.TaskStatus;
import ru.gb.repository.TaskRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Task addTask(Task task){
        return repository.save(task);
    }

    public List<Task> findTasksByStatus(TaskStatus taskStatus){
        return repository.findTaskByStatus(taskStatus);
    }

    public void changeTaskStatusByID(Long id, TaskStatus taskStatus){
        repository.changeTaskStatusByID(id, taskStatus);
    }

    public void deleteTaskByID(Long id){
        repository.deleteById(id);
    }

}
