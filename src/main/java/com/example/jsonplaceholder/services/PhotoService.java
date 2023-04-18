package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.mappers.PhotoConverter;
import com.example.jsonplaceholder.model.domain.PhotoDomain;
import com.example.jsonplaceholder.model.dto.request.PhotoRequest;
import com.example.jsonplaceholder.model.dto.response.PhotoResponse;
import com.example.jsonplaceholder.model.placeholder.PhotoPlaceholder;
import com.example.jsonplaceholder.repository.AlbumRepository;
import com.example.jsonplaceholder.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.mappers.PhotoConverter.*;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository repository;

    private AlbumRepository albumRepository;
    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<PhotoResponse> findAll() {
        List<PhotoDomain> photoList = repository.findAll();
        return generatePhotoResponseList(photoList);
    }

    public PhotoResponse findById(Long id) {
        Optional<PhotoDomain> photo = repository.findById(id);
        return photo.map(PhotoConverter::convertToPhotoResponse).orElse(null);
    }

    public PhotoResponse insert(PhotoRequest photoRequest) {
        PhotoDomain photo = convertRequestToDomain(photoRequest);
        photo = repository.save(photo);
        return convertToPhotoResponse(photo);
    }

    public PhotoResponse update(Long id, PhotoRequest photoRequest) {
        PhotoDomain photo = convertRequestToDomain(photoRequest);
        photo.setId(id);
        PhotoDomain updatedPhoto = repository.save(photo);
        return convertToPhotoResponse(updatedPhoto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    //API

    public void savePhotosFromApi() {
        List<PhotoPlaceholder> photosPlaceholder = jsonPlaceholderClient.getPhotos();
        for (PhotoPlaceholder photo : photosPlaceholder) {
            PhotoDomain photoDomain = convertPlaceholderToDomain(photo);
            repository.save(photoDomain);
        }
    }
}
