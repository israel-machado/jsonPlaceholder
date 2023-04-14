package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.model.dto.request.PhotoRequest;
import com.example.jsonplaceholder.model.dto.response.PhotoResponse;
import com.example.jsonplaceholder.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Photos")
public class PhotoController {

    @Autowired
    private PhotoService service;

    @GetMapping
    public ResponseEntity<List<PhotoResponse>> findAll() {
        List<PhotoResponse> PhotoResponseList = service.findAll();
        return ResponseEntity.ok().body(PhotoResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PhotoResponse> findById(@PathVariable Long id) {
        PhotoResponse PhotoResponse = service.findById(id);
        return ResponseEntity.ok().body(PhotoResponse);
    }

    @PhotoMapping
    public ResponseEntity<PhotoResponse> create(@RequestBody PhotoRequest PhotoRequest){
        PhotoResponse PhotoResponse = service.insert(PhotoRequest);
        return new ResponseEntity<>(PhotoResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PhotoResponse> update(@PathVariable Long id, @RequestBody PhotoRequest PhotoRequest) {
       PhotoResponse PhotoResponse = service.update(id, PhotoRequest);
       return ResponseEntity.ok().body(PhotoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
