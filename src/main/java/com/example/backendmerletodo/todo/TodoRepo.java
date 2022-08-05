package com.example.backendmerletodo.todo;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TodoRepo {

    private final Map<String, Todo> todos = new HashMap<>();

    public List<Todo> getAllTodos() {
        return new ArrayList<>(todos.values());
    }
}
