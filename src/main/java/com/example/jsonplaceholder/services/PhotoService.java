package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.converters.PhotoConverter;
import com.example.jsonplaceholder.model.Album;
import com.example.jsonplaceholder.model.Photo;
import com.example.jsonplaceholder.model.dto.request.PhotoRequest;
import com.example.jsonplaceholder.model.dto.response.PhotoResponse;
import com.example.jsonplaceholder.repository.AlbumRepository;
import com.example.jsonplaceholder.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.PhotoConverter.*;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository repository;

    private AlbumRepository albumRepository;
    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<PhotoResponse> findAll() {
        List<Photo> photoList = repository.findAll();
        return generatePhotoResponseList(photoList);
    }

    public PhotoResponse findById(Long id) {
        Optional<Photo> photo = repository.findById(id);
        return photo.map(PhotoConverter::convertToPhotoResponse).orElse(null);
    }

    public PhotoResponse insert(PhotoRequest photoRequest) {
        Photo photo = convertToPhoto(photoRequest);
        photo = repository.save(photo);
        return convertToPhotoResponse(photo);
    }

    public PhotoResponse update(Long id, PhotoRequest photoRequest) {
        Photo photo = convertToPhoto(photoRequest);
        photo.setId(id);
        Photo updatedPhoto = repository.save(photo);
        return convertToPhotoResponse(updatedPhoto);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    //API

    public void savePhotosFromApi() {
        List<Photo> photos = jsonPlaceholderClient.getPhotos();
        for (Photo photo : photos) {
            if (photo != null) {
                Album album = albumRepository.findById(photo.getAlbumId()).orElse(null);
                if (album != null) {
                    photo.setAlbumId(album.getId());
                }
                repository.save(photo);
            }
        }
    }
}
