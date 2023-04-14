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
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<AlbumResponse> create(@RequestBody AlbumRequest albumRequest){
        return new ResponseEntity<>(service.insert(albumRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponse> update(@PathVariable Long id, @RequestBody AlbumRequest albumRequest) {
       return ResponseEntity.ok().body(service.update(id, albumRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    //API

    @GetMapping("/albums/save-from-api")
    public void saveAlbumsFromApi() {
        service.saveAlbumsFromApi();
    }
}
