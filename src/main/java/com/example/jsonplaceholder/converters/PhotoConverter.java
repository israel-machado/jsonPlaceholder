package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.PhotoRequest;
import com.example.jsonplaceholder.model.dto.response.PhotoResponse;
import com.example.jsonplaceholder.model.Photo;

import java.util.List;
import java.util.stream.Collectors;

public class PhotoConverter {

    public static Photo convertToPhoto(PhotoRequest photoRequest) {
        return Photo.builder()
                .id(photoRequest.getId())
                .albumId(photoRequest.getAlbumId())
                .thumbnailUrl(photoRequest.getThumbnailUrl())
                .url(photoRequest.getUrl())
                .title(photoRequest.getTitle())
                .build();
    }

    public static PhotoResponse convertToPhotoResponse(Photo photo) {
        return PhotoResponse.builder()
                .id(photo.getId())
                .albumId(photo.getAlbumId())
                .thumbnailUrl(photo.getThumbnailUrl())
                .url(photo.getUrl())
                .title(photo.getTitle())
                .build();
    }

    public static List<PhotoResponse> generatePhotoResponseList(List<Photo> photoList) {
        return photoList.stream()
                .map(PhotoConverter::convertToPhotoResponse)
                .collect(Collectors.toList());
    }
}
