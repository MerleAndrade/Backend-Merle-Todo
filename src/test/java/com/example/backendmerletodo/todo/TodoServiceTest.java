package com.example.backendmerletodo.todo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TodoServiceTest {

    TodoRepo todoRepo = mock(TodoRepo.class);
    TodoService todoService = new TodoService(todoRepo);

    private final List<Todo> todoList = List.of(
            new Todo("123", TodoStatus.OPEN),
            new Todo("456", TodoStatus.OPEN),
            new Todo("789", TodoStatus.OPEN)
    );

    @Test
    void getAllCallsRepo() {
        //given
        when(todoRepo.getAllTodos())
                .thenReturn(todoList);
        //when
        List<Todo> actual = todoService.getAllTodos();

        //then
        Assertions.assertArrayEquals(todoList.toArray(), actual.toArray());
    }
}