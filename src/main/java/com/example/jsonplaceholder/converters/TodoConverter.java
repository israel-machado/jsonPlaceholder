package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.TodoRequest;
import com.example.jsonplaceholder.model.dto.response.TodoResponse;
import com.example.jsonplaceholder.model.domain.TodoDomain;

import java.util.List;
import java.util.stream.Collectors;

public class TodoConverter {

    public static TodoDomain convertToTodo(TodoRequest todoRequest) {
        return TodoDomain.builder()
                .id(todoRequest.getId())
                .userId(todoRequest.getUserId())
                .title(todoRequest.getTitle())
                .completed(todoRequest.getCompleted())
                .build();
    }

    public static TodoResponse convertToTodoResponse(TodoDomain todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .userId(todo.getUserId())
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }

    public static List<TodoResponse> generateTodoResponseList(List<TodoDomain> todoList) {
        return todoList.stream()
                .map(TodoConverter::convertToTodoResponse)
                .collect(Collectors.toList());
    }
}
