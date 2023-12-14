package com.geffry.todo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.geffry.todo.Models.Task;
import com.geffry.todo.Services.TaskService;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;







@RestController
@RequestMapping("/todo")
public class TodoController {

    private TaskService taskService;
    public TodoController(TaskService taskService){
        this.taskService = taskService;
    }


    @GetMapping
    public ResponseEntity<List<Task>> getTasks() {
        List<Task> tasks = taskService.getTasks();
        if(tasks.isEmpty()){
            return ResponseEntity.ofNullable(null);
        }
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Task>> getMethodName(@RequestParam int id) {
        return ResponseEntity.ok(taskService.getTask(id));
    }
    

    @PostMapping
    public ResponseEntity<Task> postTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<Task>> putTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.updateTask(task));
    }
    
    
}
