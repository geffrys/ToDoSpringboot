package com.geffry.todo.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/error")
public class ErrorController {
    @GetMapping
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.badRequest().body("Something went wrong.");
    }
    
}
