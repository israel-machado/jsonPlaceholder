package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.TodoRequest;
import com.example.jsonplaceholder.model.dto.response.TodoResponse;
import com.example.jsonplaceholder.model.Todo;

import java.util.List;
import java.util.stream.Collectors;

public class TodoConverter {

    public static Todo convertToTodo(TodoRequest todoRequest) {
        return Todo.builder()
                .id(todoRequest.getId())
                .userId(todoRequest.getUserId())
                .title(todoRequest.getTitle())
                .completed(todoRequest.getCompleted())
                .build();
    }

    public static TodoResponse convertToTodoResponse(Todo todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .userId(todo.getUserId())
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }

    public static List<TodoResponse> generateTodoResponseList(List<Todo> todoList) {
        return todoList.stream()
                .map(TodoConverter::convertToTodoResponse)
                .collect(Collectors.toList());
    }
}
