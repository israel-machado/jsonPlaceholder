package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.converters.TodoConverter;
import com.example.jsonplaceholder.model.Todo;
import com.example.jsonplaceholder.model.dto.request.TodoRequest;
import com.example.jsonplaceholder.model.dto.response.TodoResponse;
import com.example.jsonplaceholder.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.TodoConverter.*;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public List<TodoResponse> findAll() {
        List<Todo> TodoList = repository.findAll();
        return generateTodoResponseList(TodoList);
    }

    public TodoResponse findById(Long id) {
        Optional<Todo> Todo = repository.findById(id);
        return Todo.map(TodoConverter::convertToTodoResponse).orElse(null);
    }

    public TodoResponse insert(TodoRequest TodoRequest) {
        Todo Todo = convertToTodo(TodoRequest);
        Todo = repository.save(Todo);
        return convertToTodoResponse(Todo);
    }

    public TodoResponse update(Long id, TodoRequest TodoRequest) {
        Todo Todo = convertToTodo(TodoRequest);
        Todo.setId(id);
        Todo updatedTodo = repository.save(Todo);
        return convertToTodoResponse(Todo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
