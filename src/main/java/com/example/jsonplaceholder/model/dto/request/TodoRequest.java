package com.example.jsonplaceholder.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoRequest {

    private Long id;
    private Long userId;
    private String title;
    private Boolean completed;
}
