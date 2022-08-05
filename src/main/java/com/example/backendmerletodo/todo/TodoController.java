package com.example.backendmerletodo.todo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @GetMapping
    List<Todo> getAllTodos() {
        return Collections.emptyList();
    }


}