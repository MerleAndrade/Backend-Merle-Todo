package com.example.backendmerletodo.todo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {


    private final TodoRepo todoRepo;

    public TodoService(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    public List<Todo> getAllTodos() {
        return todoRepo.getAllTodos();
    }

    public Todo save(Todo todo) {
        String id = UUID.randomUUID().toString();

        Todo todoToSave = todo.withID(id);

        return todoRepo.save(todoToSave);
    }
}
