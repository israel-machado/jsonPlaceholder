package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.model.dto.request.AlbumRequest;
import com.example.jsonplaceholder.model.dto.response.AlbumResponse;
import com.example.jsonplaceholder.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Albums")
public class AlbumController {

    @Autowired
    private AlbumService service;

    @GetMapping
    public ResponseEntity<List<AlbumResponse>> findAll() {
        List<AlbumResponse> AlbumResponseList = service.findAll();
        return ResponseEntity.ok().body(AlbumResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponse> findById(@PathVariable Long id) {
        AlbumResponse AlbumResponse = service.findById(id);
        return ResponseEntity.ok().body(AlbumResponse);
    }

    @AlbumMapping
    public ResponseEntity<AlbumResponse> create(@RequestBody AlbumRequest AlbumRequest){
        AlbumResponse AlbumResponse = service.insert(AlbumRequest);
        return new ResponseEntity<>(AlbumResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponse> update(@PathVariable Long id, @RequestBody AlbumRequest AlbumRequest) {
       AlbumResponse AlbumResponse = service.update(id, AlbumRequest);
       return ResponseEntity.ok().body(AlbumResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
