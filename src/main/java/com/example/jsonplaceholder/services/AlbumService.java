package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.model.Album;
import com.example.jsonplaceholder.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository repository;

    public List<Album> getAll() {
        return repository.findAll();
    }

    public Album getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Album save(Album album) {
        return repository.save(album);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
