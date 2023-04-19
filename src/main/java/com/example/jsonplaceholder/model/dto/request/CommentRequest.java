package com.example.jsonplaceholder.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequest {

    private Long id;
    private String name;
    private String email;
    private String body;
}
