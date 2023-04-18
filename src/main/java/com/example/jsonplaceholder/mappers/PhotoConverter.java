package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.dto.request.PhotoRequest;
import com.example.jsonplaceholder.model.dto.response.PhotoResponse;
import com.example.jsonplaceholder.model.domain.PhotoDomain;
import com.example.jsonplaceholder.model.placeholder.PhotoPlaceholder;

import java.util.List;
import java.util.stream.Collectors;

public class PhotoConverter {

    // Domain

    public static PhotoDomain convertRequestToDomain(PhotoRequest photoRequest) {
        return PhotoDomain.builder()
                .id(photoRequest.getId())
                .albumId(photoRequest.getAlbumId())
                .thumbnailUrl(photoRequest.getThumbnailUrl())
                .url(photoRequest.getUrl())
                .title(photoRequest.getTitle())
                .build();
    }

    public static PhotoDomain convertPlaceholderToDomain(PhotoPlaceholder photoPlaceholder) {
        return PhotoDomain.builder()
                .id(photoPlaceholder.getId())
                .albumId(photoPlaceholder.getAlbumId())
                .thumbnailUrl(photoPlaceholder.getThumbnailUrl())
                .url(photoPlaceholder.getUrl())
                .title(photoPlaceholder.getTitle())
                .build();
    }

    // Response

    public static PhotoResponse convertToPhotoResponse(PhotoDomain photo) {
        return PhotoResponse.builder()
                .id(photo.getId())
                .albumId(photo.getAlbumId())
                .thumbnailUrl(photo.getThumbnailUrl())
                .url(photo.getUrl())
                .title(photo.getTitle())
                .build();
    }

    public static List<PhotoResponse> generatePhotoResponseList(List<PhotoDomain> photoList) {
        return photoList.stream()
                .map(PhotoConverter::convertToPhotoResponse)
                .collect(Collectors.toList());
    }
}
