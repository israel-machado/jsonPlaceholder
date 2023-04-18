package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.dto.request.AlbumRequest;
import com.example.jsonplaceholder.model.dto.response.AlbumResponse;
import com.example.jsonplaceholder.model.domain.AlbumDomain;
import com.example.jsonplaceholder.model.placeholder.AlbumPlaceholder;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumConverter {

    // Domain

    public static AlbumDomain convertRequestToDomain(AlbumRequest albumRequest) {
        return AlbumDomain.builder()
                .id(albumRequest.getId())
                .userId(albumRequest.getUserId())
                .title(albumRequest.getTitle())
                .build();
    }

    public static AlbumDomain convertPlaceholderToDomain(AlbumPlaceholder albumPlaceholder) {
        return AlbumDomain.builder()
                .id(albumPlaceholder.getId())
                .userId(albumPlaceholder.getUserId())
                .title(albumPlaceholder.getTitle())
                .build();
    }

    // Response

    public static AlbumResponse convertToAlbumResponse(AlbumDomain album) {
        return AlbumResponse.builder()
                .id(album.getId())
                .userId(album.getUserId())
                .title(album.getTitle())
                .build();
    }

    public static List<AlbumResponse> generateAlbumResponseList(List<AlbumDomain> albumList) {
        return albumList.stream()
                .map(AlbumConverter::convertToAlbumResponse)
                .collect(Collectors.toList());
    }
}
