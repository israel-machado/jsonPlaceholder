package com.example.jsonplaceholder.model.dto.response.sup;

import com.example.jsonplaceholder.model.sup.Geo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressResponse {

    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}
