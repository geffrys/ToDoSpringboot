package com.geffry.todo.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.geffry.todo.Models.Task;
import com.geffry.todo.Repositories.TaskRepository;

import jakarta.transaction.Transactional;

@Service
public class TaskService {
    private TaskRepository taskRepository;
    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(int id){
        return taskRepository.findById(id);
    }

    @Transactional
    public Task saveTask(Task task){
        return taskRepository.save(task);
    }

    public Optional<Task> updateTask(Task task){
        if (taskRepository.existsById(task.getId())) {
            return Optional.of(taskRepository.save(task));
        }
        return Optional.empty();
    }
    
}
