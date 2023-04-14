package com.example.jsonplaceholder.model.dto.response.sup;

import com.example.jsonplaceholder.model.sup.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoResponse {

    private Long id;
    private String lat;
    private String lng;

    private AddressResponse addressResponse;
}
