package com.example.jsonplaceholder.converters.sup;


import com.example.jsonplaceholder.model.dto.request.sup.GeoRequest;
import com.example.jsonplaceholder.model.dto.response.sup.GeoResponse;
import com.example.jsonplaceholder.model.domain.user.GeoDomain;

import java.util.List;
import java.util.stream.Collectors;

public class GeoConverter {

    public static GeoDomain convertToGeo(GeoRequest geoRequest) {
        return GeoDomain.builder()
                .id(geoRequest.getId())
                .lng(geoRequest.getLng())
                .lat(geoRequest.getLat())
                .build();
    }

    public static GeoResponse convertToGeoResponse(GeoDomain geo) {
        return GeoResponse.builder()
                .id(geo.getId())
                .lng(geo.getLng())
                .lat(geo.getLat())
                .build();
    }

    public static List<GeoResponse> generateGeoResponseList(List<GeoDomain> geoList) {
        return geoList.stream()
                .map(GeoConverter::convertToGeoResponse)
                .collect(Collectors.toList());
    }
}
