package com.example.jsonplaceholder.converters;

import com.example.jsonplaceholder.model.dto.request.PhotoRequest;
import com.example.jsonplaceholder.model.dto.response.sup.PhotoResponse;
import com.example.jsonplaceholder.model.sup.Photo;

import java.util.List;
import java.util.stream.Collectors;

public class PhotoConverter {

    public static Photo convertToPhoto(PhotoRequest PhotoRequest) {

  
                
    }

    public static PhotoResponse convertToPhotoResponse(Photo Photo) {
        

    }

    public static List<PhotoResponse> generatePhotoResponseList(List<Photo> PhotoList) {
        List<PhotoResponse> PhotoResponseList = PhotoList.stream()
                .map(PhotoConverter::convertToPhotoResponse)
                .collect(Collectors.toList());
        return PhotoResponseList;
    }
}
