package com.example.jsonplaceholder.converters.sup;

import com.example.jsonplaceholder.model.dto.request.GeoRequest;
import com.example.jsonplaceholder.model.dto.response.sup.GeoResponse;
import com.example.jsonplaceholder.model.sup.Geo;

import java.util.List;
import java.util.stream.Collectors;

public class GeoConverter {

    public static Geo convertToGeo(GeoRequest GeoRequest) {

  
                
    }

    public static GeoResponse convertToGeoResponse(Geo Geo) {
        

    }

    public static List<GeoResponse> generateGeoResponseList(List<Geo> GeoList) {
        List<GeoResponse> GeoResponseList = GeoList.stream()
                .map(GeoConverter::convertToGeoResponse)
                .collect(Collectors.toList());
        return GeoResponseList;
    }
}
