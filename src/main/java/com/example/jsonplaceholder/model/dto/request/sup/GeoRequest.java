package com.example.jsonplaceholder.model.dto.request.sup;

import com.example.jsonplaceholder.model.sup.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeoRequest {

    private Long id;
    private String lat;
    private String lng;

    private AddressRequest addressRequest;
}
