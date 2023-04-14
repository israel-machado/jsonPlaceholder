package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.model.dto.request.CommentRequest;
import com.example.jsonplaceholder.model.dto.response.CommentResponse;
import com.example.jsonplaceholder.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comments")
public class CommentController {

    @Autowired
    private CommentService service;

    @GetMapping
    public ResponseEntity<List<CommentResponse>> findAll() {
        List<CommentResponse> CommentResponseList = service.findAll();
        return ResponseEntity.ok().body(CommentResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> findById(@PathVariable Long id) {
        CommentResponse CommentResponse = service.findById(id);
        return ResponseEntity.ok().body(CommentResponse);
    }

    @CommentMapping
    public ResponseEntity<CommentResponse> create(@RequestBody CommentRequest CommentRequest){
        CommentResponse CommentResponse = service.insert(CommentRequest);
        return new ResponseEntity<>(CommentResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponse> update(@PathVariable Long id, @RequestBody CommentRequest CommentRequest) {
       CommentResponse CommentResponse = service.update(id, CommentRequest);
       return ResponseEntity.ok().body(CommentResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
