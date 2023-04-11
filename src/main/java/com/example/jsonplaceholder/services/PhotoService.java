package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.model.Photo;
import com.example.jsonplaceholder.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository repository;

    public List<Photo> getAll() {
        return repository.findAll();
    }

    public Photo getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Photo save(Photo Photo) {
        return repository.save(Photo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
