package com.example.jsonplaceholder.mappers;

import com.example.jsonplaceholder.model.domain.user.UserDomain;
import com.example.jsonplaceholder.model.dto.request.AlbumRequest;
import com.example.jsonplaceholder.model.dto.response.AlbumResponse;
import com.example.jsonplaceholder.model.domain.AlbumDomain;
import com.example.jsonplaceholder.model.placeholder.AlbumPlaceholder;
import org.apache.catalina.User;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumConverter {

    // Domain

    public static AlbumDomain convertAlbumRequestToDomain(AlbumRequest albumRequest) {
        return AlbumDomain.builder()
                .id(albumRequest.getId())
                .title(albumRequest.getTitle())
                .build();
    }

    public static AlbumDomain convertAlbumPlaceholderToDomain(AlbumPlaceholder albumPlaceholder) {
        return AlbumDomain.builder()
                .id(albumPlaceholder.getId())
                .title(albumPlaceholder.getTitle())
                .build();
    }

    // Response

    public static AlbumResponse convertAlbumDomainToResponse(AlbumDomain album) {
        return AlbumResponse.builder()
                .id(album.getId())
                .title(album.getTitle())
                .build();
    }

    public static List<AlbumResponse> generateAlbumDomainListToAlbumResponseList(List<AlbumDomain> albumList) {
        return albumList.stream()
                .map(AlbumConverter::convertAlbumDomainToResponse)
                .collect(Collectors.toList());
    }
}
