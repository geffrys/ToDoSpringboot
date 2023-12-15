package com.geffry.todo.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.geffry.todo.DTO.ResponseDTO;
import com.geffry.todo.Database.Models.Task;
import com.geffry.todo.Services.TaskService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;








@RestController
@RequestMapping("/todo")
public class TodoController {

    private TaskService taskService;
    public TodoController(TaskService taskService){
        this.taskService = taskService;
    }


    @GetMapping
    public ResponseEntity<ResponseDTO<List<Task>>> getTasks() {
        ResponseDTO<List<Task>> responseDTO = new ResponseDTO<List<Task>>();
        try {
            List<Task> tasks = taskService.getTasks();
            responseDTO.setData(tasks);
            responseDTO.setError(false);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            responseDTO.setError(true);
            responseDTO.setErrorMessage(e.getMessage());
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO<Task>> getTask(@RequestParam int id) {
        ResponseDTO<Task> responseDTO = new ResponseDTO<Task>();
        try{
            Optional<Task> task = taskService.getTask(id);
            responseDTO.setData(task.get());
            responseDTO.setError(false);
            return ResponseEntity.ok(responseDTO);
        }catch(Exception e){
            responseDTO.setData(null);
            responseDTO.setError(true);
            responseDTO.setErrorMessage(e.getMessage());
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
    

    @PostMapping
    public ResponseEntity<ResponseDTO<Task>> postTask(@RequestBody Task task) {
        task.setFechaCreacion(LocalDateTime.now());
        task.setFinalizada(false);
        try {
            ResponseDTO<Task> responseDTO = new ResponseDTO<Task>();
            responseDTO.setData(taskService.saveTask(task));
            responseDTO.setError(false);
            return ResponseEntity.ok(responseDTO);
        } catch (Exception e) {
            ResponseDTO<Task> responseDTO = new ResponseDTO<Task>();
            responseDTO.setData(null);
            responseDTO.setError(true);
            responseDTO.setErrorMessage(e.getMessage());
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PutMapping("/completed/{id}")
    public ResponseEntity<ResponseDTO<String>> markAsCompleted(@PathVariable Integer id) {
        ResponseDTO<String> responseDTO = new ResponseDTO<String>();
        try {
            taskService.markTaskFinished(id);
            responseDTO.setData(null);
            responseDTO.setError(false);
            return ResponseEntity.ok().body(responseDTO);
        } catch (Exception e) {
            responseDTO.setData(e.getMessage());
            responseDTO.setError(true);
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }
}
