package com.example.backendmerletodo.todo;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
class TodoController {

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

    @GetMapping("{id}")
    Todo getTodoByID(@PathVariable String id) {
        return todoService.getById(id);

    }

    @PutMapping(path = {"{id}/update", "{id}"})
    Todo update(@PathVariable String id, @RequestBody Todo todo) {
        if (!todo.id().equals(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The id in the url does not match the request body's id");
        }
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    void delete(@PathVariable String id) {
        todoService.delete(id);
    }


}
