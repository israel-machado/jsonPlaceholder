package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.converters.TodoConverter;
import com.example.jsonplaceholder.model.Todo;
import com.example.jsonplaceholder.model.User;
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
        List<Todo> todoList = repository.findAll();
        return generateTodoResponseList(todoList);
    }

    public TodoResponse findById(Long id) {
        Optional<Todo> todo = repository.findById(id);
        return todo.map(TodoConverter::convertToTodoResponse).orElse(null);
    }

    public TodoResponse insert(TodoRequest todoRequest) {
        Todo todo = convertToTodo(todoRequest);
        todo = repository.save(todo);
        return convertToTodoResponse(todo);
    }

    public TodoResponse update(Long id, TodoRequest todoRequest) {
        Todo todo = convertToTodo(todoRequest);
        todo.setId(id);
        Todo updatedTodo = repository.save(todo);
        return convertToTodoResponse(updatedTodo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public void saveTodosFromApi() {
        List<Todo> todos = jsonPlaceholderClient.getTodos();
        for (Todo todo : todos) {
            if (todo != null) {
                User user = userRepository.findById(todo.getUserId()).orElse(null);
                if (user != null) {
                    todo.setUserId(user.getId());
                }
                repository.save(todo);
            }
        }
    }
}
