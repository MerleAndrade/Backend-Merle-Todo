package com.example.backendmerletodo.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {


    private TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> getAllTodos() {
        return todoRepo.getAllTodos();
    }
}
