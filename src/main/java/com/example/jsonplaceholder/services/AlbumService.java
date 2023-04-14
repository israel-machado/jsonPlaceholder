package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.converters.AlbumConverter;
import com.example.jsonplaceholder.model.Album;
import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.request.AlbumRequest;
import com.example.jsonplaceholder.model.dto.response.AlbumResponse;
import com.example.jsonplaceholder.repository.AlbumRepository;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.AlbumConverter.*;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository repository;

    private UserRepository userRepository;

    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<AlbumResponse> findAll() {
        List<Album> albumList = repository.findAll();
        return generateAlbumResponseList(albumList);
    }

    public AlbumResponse findById(Long id) {
        Optional<Album> album = repository.findById(id);
        return album.map(AlbumConverter::convertToAlbumResponse).orElse(null);
    }

    public AlbumResponse insert(AlbumRequest albumRequest) {
        Album album = convertToAlbum(albumRequest);
        album = repository.save(album);
        return convertToAlbumResponse(album);
    }

    public AlbumResponse update(Long id, AlbumRequest albumRequest) {
        Album album = convertToAlbum(albumRequest);
        album.setId(id);
        Album updatedAlbum = repository.save(album);
        return convertToAlbumResponse(updatedAlbum);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    //API

    public void saveAlbumsFromApi() {
        List<Album> albums = jsonPlaceholderClient.getAlbums();
        for (Album album : albums) {
            if (album != null) {
                User user = userRepository.findById(album.getUserId()).orElse(null);
                if (user != null) {
                    album.setUserId(user.getId());
                }
                repository.save(album);
            }
        }
    }
}
