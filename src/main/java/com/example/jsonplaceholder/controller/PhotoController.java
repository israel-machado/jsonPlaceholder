package com.example.jsonplaceholder.controller;

import com.example.jsonplaceholder.model.Photo;
import com.example.jsonplaceholder.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoController {

    @Autowired
    private PhotoService service;

    @GetMapping
    public List<Photo> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Photo getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Photo create(@RequestBody Photo photo) {
        return service.save(photo);
    }

    @PutMapping("/{id}")
    public Photo update(@PathVariable Long id, @RequestBody Photo photo) {
        photo.setId(id);
        return service.save(photo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
