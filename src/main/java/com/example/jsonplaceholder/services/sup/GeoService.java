package com.example.jsonplaceholder.services.sup;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.converters.sup.GeoConverter;
import com.example.jsonplaceholder.model.sup.Geo;
import com.example.jsonplaceholder.model.dto.request.sup.GeoRequest;
import com.example.jsonplaceholder.model.dto.response.sup.GeoResponse;
import com.example.jsonplaceholder.repository.sup.GeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.sup.GeoConverter.*;

@Service
public class GeoService {

    @Autowired
    private GeoRepository repository;

    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<GeoResponse> findAll() {
        List<Geo> geoList = repository.findAll();
        return generateGeoResponseList(geoList);
    }

    public GeoResponse findById(Long id) {
        Optional<Geo> geo = repository.findById(id);
        return geo.map(GeoConverter::convertToGeoResponse).orElse(null);
    }

    public GeoResponse insert(GeoRequest geoRequest) {
        Geo geo = convertToGeo(geoRequest);
        geo = repository.save(geo);
        return convertToGeoResponse(geo);
    }

    public GeoResponse update(Long id, GeoRequest geoRequest) {
        Geo geo = convertToGeo(geoRequest);
        geo.setId(id);
        Geo updatedGeo = repository.save(geo);
        return convertToGeoResponse(updatedGeo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
