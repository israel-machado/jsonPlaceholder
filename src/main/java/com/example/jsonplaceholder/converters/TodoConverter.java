package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.TodoRequest;
import com.example.jsonplaceholder.model.dto.response.sup.TodoResponse;
import com.example.jsonplaceholder.model.sup.Todo;

import java.util.List;
import java.util.stream.Collectors;

public class TodoConverter {

    public static Todo convertToTodo(TodoRequest TodoRequest) {

  
                
    }

    public static TodoResponse convertToTodoResponse(Todo Todo) {
        

    }

    public static List<TodoResponse> generateTodoResponseList(List<Todo> TodoList) {
        List<TodoResponse> TodoResponseList = TodoList.stream()
                .map(TodoConverter::convertToTodoResponse)
                .collect(Collectors.toList());
        return TodoResponseList;
    }
}
