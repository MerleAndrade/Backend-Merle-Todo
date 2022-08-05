package com.example.backendmerletodo;

import com.example.backendmerletodo.todo.Todo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TodoIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void expectEmptyListOnGet() throws Exception {
        mockMvc.perform(
                        get("http://localhost:3000/api/todo"))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        []
                        """));

    }

    @Test
    void expectSuccessfulPost() throws Exception {
        String actual = mockMvc.perform(
                        post("http://localhost:3000/api/todo")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                                        {
                                           "description": "Wäsche waschen",
                                            "status": "OPEN"
                                        }
                                        """))
                .andExpect(status().isOk())
                .andExpect(content().json("""
                        {
                            "description": "Wäsche waschen",
                            "status": "OPEN"
                        }
                        """))
                .andReturn()
                .getResponse()
                .getContentAsString();
        Todo actualTodo = objectMapper.readValue(actual, Todo.class);
        assertThat(actualTodo.id())
                .isNotBlank();
    }


}

