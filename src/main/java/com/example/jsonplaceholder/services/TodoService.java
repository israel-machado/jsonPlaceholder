package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.converters.TodoConverter;
import com.example.jsonplaceholder.model.domain.TodoDomain;
import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.dto.request.TodoRequest;
import com.example.jsonplaceholder.model.dto.response.TodoResponse;
import com.example.jsonplaceholder.repository.TodoRepository;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.TodoConverter.*;

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
        TodoDomain todo = convertToTodo(todoRequest);
        todo = repository.save(todo);
        return convertToTodoResponse(todo);
    }

    public TodoResponse update(Long id, TodoRequest todoRequest) {
        TodoDomain todo = convertToTodo(todoRequest);
        todo.setId(id);
        TodoDomain updatedTodo = repository.save(todo);
        return convertToTodoResponse(updatedTodo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void saveTodosFromApi() {
        List<TodoDomain> todos = jsonPlaceholderClient.getTodos();
        for (TodoDomain todo : todos) {
            if (todo != null) {
                UserDomain user = userRepository.findById(todo.getUserId()).orElse(null);
                if (user != null) {
                    todo.setUserId(user.getId());
                }
                repository.save(todo);
            }
        }
    }
}
