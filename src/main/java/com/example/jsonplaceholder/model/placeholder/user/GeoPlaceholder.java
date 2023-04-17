package com.example.jsonplaceholder.model.placeholder.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GeoPlaceholder {

    private String lat;
    private String lng;
}
