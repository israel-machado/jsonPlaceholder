package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.domain.AlbumDomain;
import com.example.jsonplaceholder.model.dto.request.PhotoRequest;
import com.example.jsonplaceholder.model.dto.response.PhotoResponse;
import com.example.jsonplaceholder.model.domain.PhotoDomain;
import com.example.jsonplaceholder.model.placeholder.PhotoPlaceholder;

import java.util.List;
import java.util.stream.Collectors;

public class PhotoConverter {

    // Domain

    public static PhotoDomain convertPhotoRequestToDomain(PhotoRequest photoRequest) {
        return PhotoDomain.builder()
                .id(photoRequest.getId())
                .thumbnailUrl(photoRequest.getThumbnailUrl())
                .url(photoRequest.getUrl())
                .title(photoRequest.getTitle())
                .build();
    }

    public static PhotoDomain convertPhotoPlaceholderToDomain(PhotoPlaceholder photoPlaceholder) {
        return PhotoDomain.builder()
                .id(photoPlaceholder.getId())
                .thumbnailUrl(photoPlaceholder.getThumbnailUrl())
                .url(photoPlaceholder.getUrl())
                .title(photoPlaceholder.getTitle())
                .build();
    }

    // Response

    public static PhotoResponse convertPhotoDomainToPhotoResponse(PhotoDomain photo) {

        return PhotoResponse.builder()
                .id(photo.getId())
                .thumbnailUrl(photo.getThumbnailUrl())
                .url(photo.getUrl())
                .title(photo.getTitle())
                .build();
    }

    public static List<PhotoResponse> generatePhotoDomainListToPhotoResponseList(List<PhotoDomain> photoList) {
        return photoList.stream()
                .map(PhotoConverter::convertPhotoDomainToPhotoResponse)
                .collect(Collectors.toList());
    }
}
