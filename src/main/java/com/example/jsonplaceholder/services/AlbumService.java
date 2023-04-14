package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.converters.AlbumConverter;
import com.example.jsonplaceholder.model.Album;
import com.example.jsonplaceholder.model.dto.request.AlbumRequest;
import com.example.jsonplaceholder.model.dto.response.AlbumResponse;
import com.example.jsonplaceholder.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.AlbumConverter.*;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository repository;

    public List<AlbumResponse> findAll() {
        List<Album> AlbumList = repository.findAll();
        return generateAlbumResponseList(AlbumList);
    }

    public AlbumResponse findById(Long id) {
        Optional<Album> Album = repository.findById(id);
        return Album.map(AlbumConverter::convertToAlbumResponse).orElse(null);
    }

    public AlbumResponse insert(AlbumRequest AlbumRequest) {
        Album Album = convertToAlbum(AlbumRequest);
        Album = repository.save(Album);
        return convertToAlbumResponse(Album);
    }

    public AlbumResponse update(Long id, AlbumRequest AlbumRequest) {
        Album Album = convertToAlbum(AlbumRequest);
        Album.setId(id);
        Album updatedAlbum = repository.save(Album);
        return convertToAlbumResponse(Album);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
