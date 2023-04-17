package com.example.jsonplaceholder.model.placeholder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentPlaceholder {

    private Long id;
    private Long postId;
    private String name;
    private String email;
    private String body;
}
