package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.mappers.TodoConverter;
import com.example.jsonplaceholder.model.domain.TodoDomain;
import com.example.jsonplaceholder.model.dto.request.TodoRequest;
import com.example.jsonplaceholder.model.dto.response.TodoResponse;
import com.example.jsonplaceholder.model.placeholder.TodoPlaceholder;
import com.example.jsonplaceholder.repository.TodoRepository;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.mappers.TodoConverter.*;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    private UserRepository userRepository;
    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<TodoResponse> findAll() {
        List<TodoDomain> todoList = repository.findAll();
        return generateTodoResponseList(todoList);
    }

    public TodoResponse findById(Long id) {
        Optional<TodoDomain> todo = repository.findById(id);
        return todo.map(TodoConverter::convertToTodoResponse).orElse(null);
    }

    public TodoResponse insert(TodoRequest todoRequest) {
        TodoDomain todo = convertRequestToDomain(todoRequest);
        todo = repository.save(todo);
        return convertToTodoResponse(todo);
    }

    public TodoResponse update(Long id, TodoRequest todoRequest) {
        TodoDomain todo = convertRequestToDomain(todoRequest);
        todo.setId(id);
        TodoDomain updatedTodo = repository.save(todo);
        return convertToTodoResponse(updatedTodo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void saveTodosFromApi() {
        List<TodoPlaceholder> todosPlaceholder = jsonPlaceholderClient.getTodos();
        for (TodoPlaceholder todo : todosPlaceholder) {
            TodoDomain todoDomain = convertPlaceholderToDomain(todo);
            repository.save(todoDomain);
        }
    }
}
