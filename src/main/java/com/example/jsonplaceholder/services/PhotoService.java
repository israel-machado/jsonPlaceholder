package com.example.jsonplaceholder.services;

import com.example.jsonplaceholder.converters.PhotoConverter;
import com.example.jsonplaceholder.model.Photo;
import com.example.jsonplaceholder.model.dto.request.PhotoRequest;
import com.example.jsonplaceholder.model.dto.response.PhotoResponse;
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

    public List<PhotoResponse> findAll() {
        List<Photo> PhotoList = repository.findAll();
        return generatePhotoResponseList(PhotoList);
    }

    public PhotoResponse findById(Long id) {
        Optional<Photo> Photo = repository.findById(id);
        return Photo.map(PhotoConverter::convertToPhotoResponse).orElse(null);
    }

    public PhotoResponse insert(PhotoRequest PhotoRequest) {
        Photo Photo = convertToPhoto(PhotoRequest);
        Photo = repository.save(Photo);
        return convertToPhotoResponse(Photo);
    }

    public PhotoResponse update(Long id, PhotoRequest PhotoRequest) {
        Photo Photo = convertToPhoto(PhotoRequest);
        Photo.setId(id);
        Photo updatedPhoto = repository.save(Photo);
        return convertToPhotoResponse(Photo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
