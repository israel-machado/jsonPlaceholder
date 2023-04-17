package com.example.jsonplaceholder.model.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PhotoPlaceholder {

    private Long id;
    private Long albumId;
    private String title;
    private String url;
    private String thumbnailUrl;
}
