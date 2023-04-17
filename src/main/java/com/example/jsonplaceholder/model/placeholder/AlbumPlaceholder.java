package com.example.jsonplaceholder.model.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlbumPlaceholder {

    private Long id;
    private Long userId;
    private String title;
}
