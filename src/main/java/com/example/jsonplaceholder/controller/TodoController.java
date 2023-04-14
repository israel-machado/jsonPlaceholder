package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.model.dto.request.TodoRequest;
import com.example.jsonplaceholder.model.dto.response.TodoResponse;
import com.example.jsonplaceholder.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public ResponseEntity<List<TodoResponse>> findAll() {
        List<TodoResponse> TodoResponseList = service.findAll();
        return ResponseEntity.ok().body(TodoResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> findById(@PathVariable Long id) {
        TodoResponse TodoResponse = service.findById(id);
        return ResponseEntity.ok().body(TodoResponse);
    }

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest TodoRequest){
        TodoResponse TodoResponse = service.insert(TodoRequest);
        return new ResponseEntity<>(TodoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest TodoRequest) {
       TodoResponse TodoResponse = service.update(id, TodoRequest);
       return ResponseEntity.ok().body(TodoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
