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
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping
    public ResponseEntity<List<TodoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoRequest todoRequest){
        return new ResponseEntity<>(service.insert(todoRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoRequest todoRequest) {
       return ResponseEntity.ok().body(service.update(id, todoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //API

    @GetMapping("/save-from-api")
    public void saveTodosFromApi() {
        service.saveTodosFromApi();
    }
}
