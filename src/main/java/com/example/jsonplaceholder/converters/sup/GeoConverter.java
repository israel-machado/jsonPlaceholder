package com.example.jsonplaceholder.converters.sup;


import com.example.jsonplaceholder.model.dto.request.sup.GeoRequest;
import com.example.jsonplaceholder.model.dto.response.sup.GeoResponse;
import com.example.jsonplaceholder.model.sup.Geo;

import java.util.List;
import java.util.stream.Collectors;

public class GeoConverter {

    public static Geo convertToGeo(GeoRequest geoRequest) {
        return Geo.builder()
                .id(geoRequest.getId())
                .lng(geoRequest.getLng())
                .lat(geoRequest.getLat())
                .build();
    }

    public static GeoResponse convertToGeoResponse(Geo geo) {
        return GeoResponse.builder()
                .id(geo.getId())
                .lng(geo.getLng())
                .lat(geo.getLat())
                .build();
    }

    public static List<GeoResponse> generateGeoResponseList(List<Geo> geoList) {
        return geoList.stream()
                .map(GeoConverter::convertToGeoResponse)
                .collect(Collectors.toList());
    }
}
