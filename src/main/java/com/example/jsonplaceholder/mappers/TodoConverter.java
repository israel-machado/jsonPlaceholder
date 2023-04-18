package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.dto.request.TodoRequest;
import com.example.jsonplaceholder.model.dto.response.TodoResponse;
import com.example.jsonplaceholder.model.domain.TodoDomain;
import com.example.jsonplaceholder.model.placeholder.TodoPlaceholder;

import java.util.List;
import java.util.stream.Collectors;

public class TodoConverter {

    // TodoDomain

    public static TodoDomain convertRequestToDomain(TodoRequest todoRequest) {
        return TodoDomain.builder()
                .id(todoRequest.getId())
                .userId(todoRequest.getUserId())
                .title(todoRequest.getTitle())
                .completed(todoRequest.getCompleted())
                .build();
    }

    public static TodoDomain convertPlaceholderToDomain(TodoPlaceholder todoPlaceholder) {
        return TodoDomain.builder()
                .id(todoPlaceholder.getId())
                .userId(todoPlaceholder.getUserId())
                .title(todoPlaceholder.getTitle())
                .completed(todoPlaceholder.getCompleted())
                .build();
    }

    // TodoResponse

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
