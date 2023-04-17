package com.example.jsonplaceholder.model.placeholder.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressPlaceholder {

    private String street;
    private String suite;
    private String city;
    private String zipcode;

    private GeoPlaceholder geo;
}
