package com.example.backendmerletodo.todo;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    Todo postTodo(@RequestBody Todo todo) {
        return todoService.save(todo);

    }


}
