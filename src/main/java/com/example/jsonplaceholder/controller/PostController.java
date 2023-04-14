package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.model.dto.request.PostRequest;
import com.example.jsonplaceholder.model.dto.response.PostResponse;
import com.example.jsonplaceholder.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<PostResponse>> findAll() {
        List<PostResponse> PostResponseList = service.findAll();
        return ResponseEntity.ok().body(PostResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findById(@PathVariable Long id) {
        PostResponse PostResponse = service.findById(id);
        return ResponseEntity.ok().body(PostResponse);
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest PostRequest){
        PostResponse PostResponse = service.insert(PostRequest);
        return new ResponseEntity<>(PostResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> update(@PathVariable Long id, @RequestBody PostRequest PostRequest) {
       PostResponse PostResponse = service.update(id, PostRequest);
       return ResponseEntity.ok().body(PostResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
