package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.mappers.AlbumConverter;
import com.example.jsonplaceholder.model.domain.AlbumDomain;
import com.example.jsonplaceholder.model.dto.request.AlbumRequest;
import com.example.jsonplaceholder.model.dto.response.AlbumResponse;
import com.example.jsonplaceholder.model.placeholder.AlbumPlaceholder;
import com.example.jsonplaceholder.repository.AlbumRepository;
import com.example.jsonplaceholder.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.mappers.AlbumConverter.*;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository repository;

    private UserRepository userRepository;

    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<AlbumResponse> findAll() {
        List<AlbumDomain> albumList = repository.findAll();
        return generateAlbumDomainListToAlbumResponseList(albumList);
    }

    public AlbumResponse findById(Long id) {
        Optional<AlbumDomain> album = repository.findById(id);
        return album.map(AlbumConverter::convertAlbumDomainToResponse).orElse(null);
    }

    public AlbumResponse insert(AlbumRequest albumRequest) {
        AlbumDomain album = convertAlbumRequestToDomain(albumRequest);
        album = repository.save(album);
        return convertAlbumDomainToResponse(album);
    }

    public AlbumResponse update(Long id, AlbumRequest albumRequest) {
        AlbumDomain album = convertAlbumRequestToDomain(albumRequest);
        album.setId(id);
        AlbumDomain updatedAlbum = repository.save(album);
        return convertAlbumDomainToResponse(updatedAlbum);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    //API

    public void saveAlbumsFromApi() {
        List<AlbumPlaceholder> albumsPlaceholder = jsonPlaceholderClient.getAlbums();
        for (AlbumPlaceholder album : albumsPlaceholder) {
            AlbumDomain albumDomain = convertAlbumPlaceholderToDomain(album);
            repository.save(albumDomain);
        }
    }
}
