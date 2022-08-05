package com.example.backendmerletodo.todo;

public record Todo(
        String id,
        String description,
        TodoStatus status
) {

    Todo(

            String description,
            TodoStatus status
    ) {

        this(null, description, status);
    }


    public Todo withID(String id) {
        return new Todo(id, description, status);
    }
}
