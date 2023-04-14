package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.AlbumRequest;
import com.example.jsonplaceholder.model.dto.response.AlbumResponse;
import com.example.jsonplaceholder.model.Album;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumConverter {

    public static Album convertToAlbum(AlbumRequest albumRequest) {
        return Album.builder()
                .id(albumRequest.getId())
                .userId(albumRequest.getUserId())
                .title(albumRequest.getTitle())
                .build();
    }

    public static AlbumResponse convertToAlbumResponse(Album album) {
        return AlbumResponse.builder()
                .id(album.getId())
                .userId(album.getUserId())
                .title(album.getTitle())
                .build();
    }

    public static List<AlbumResponse> generateAlbumResponseList(List<Album> albumList) {
        return albumList.stream()
                .map(AlbumConverter::convertToAlbumResponse)
                .collect(Collectors.toList());
    }
}
