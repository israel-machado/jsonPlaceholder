package com.example.jsonplaceholder.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhotoResponse {

    private Long id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
