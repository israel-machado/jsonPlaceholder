package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.dto.request.TodoRequest;
import com.example.jsonplaceholder.model.dto.response.TodoResponse;
import com.example.jsonplaceholder.model.domain.TodoDomain;
import com.example.jsonplaceholder.model.placeholder.TodoPlaceholder;

import java.util.List;
import java.util.stream.Collectors;

public class TodoConverter {

    // TodoDomain

    public static TodoDomain convertTodoRequestToDomain(TodoRequest todoRequest) {
        return TodoDomain.builder()
                .id(todoRequest.getId())
                .title(todoRequest.getTitle())
                .completed(todoRequest.getCompleted())
                .build();
    }

    public static TodoDomain convertTodoPlaceholderToDomain(TodoPlaceholder todoPlaceholder) {
        return TodoDomain.builder()
                .id(todoPlaceholder.getId())
                .title(todoPlaceholder.getTitle())
                .completed(todoPlaceholder.getCompleted())
                .build();
    }

    // TodoResponse

    public static TodoResponse convertTodoDomainToResponse(TodoDomain todo) {
        return TodoResponse.builder()
                .id(todo.getId())
                .title(todo.getTitle())
                .completed(todo.getCompleted())
                .build();
    }

    public static List<TodoResponse> generateTodoDomainListToTodoResponseList(List<TodoDomain> todoList) {
        return todoList.stream()
                .map(TodoConverter::convertTodoDomainToResponse)
                .collect(Collectors.toList());
    }
}
