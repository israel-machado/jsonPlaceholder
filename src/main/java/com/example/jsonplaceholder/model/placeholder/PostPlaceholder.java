package com.example.jsonplaceholder.model.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPlaceholder {

    private Long id;
    private String title;
    private String body;
}
