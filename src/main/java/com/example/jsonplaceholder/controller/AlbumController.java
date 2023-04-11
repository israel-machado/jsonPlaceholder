package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.model.Album;
import com.example.jsonplaceholder.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    @Autowired
    private AlbumService service;

    @GetMapping
    public List<Album> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Album getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Album create(@RequestBody Album album) {
        return service.save(album);
    }

    @PutMapping("/{id}")
    public Album update(@PathVariable Long id, @RequestBody Album album) {
        album.setId(id);
        return service.save(album);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
