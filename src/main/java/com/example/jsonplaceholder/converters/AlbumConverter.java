package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.AlbumRequest;
import com.example.jsonplaceholder.model.dto.response.sup.AlbumResponse;
import com.example.jsonplaceholder.model.sup.Album;

import java.util.List;
import java.util.stream.Collectors;

public class AlbumConverter {

    public static Album convertToAlbum(AlbumRequest AlbumRequest) {

  
                
    }

    public static AlbumResponse convertToAlbumResponse(Album Album) {
        

    }

    public static List<AlbumResponse> generateAlbumResponseList(List<Album> AlbumList) {
        List<AlbumResponse> AlbumResponseList = AlbumList.stream()
                .map(AlbumConverter::convertToAlbumResponse)
                .collect(Collectors.toList());
        return AlbumResponseList;
    }
}
