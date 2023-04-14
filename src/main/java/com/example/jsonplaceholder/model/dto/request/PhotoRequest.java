package com.example.jsonplaceholder.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoRequest {

    private Long id;
    private Long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;
}
