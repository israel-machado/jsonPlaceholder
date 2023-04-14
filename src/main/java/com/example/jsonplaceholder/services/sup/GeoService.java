package com.example.jsonplaceholder.services.sup;

import com.example.jsonplaceholder.converters.GeoConverter;
import com.example.jsonplaceholder.model.Geo;
import com.example.jsonplaceholder.model.dto.request.GeoRequest;
import com.example.jsonplaceholder.model.dto.response.GeoResponse;
import com.example.jsonplaceholder.repository.GeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.GeoConverter.*;

@Service
public class GeoService {

    @Autowired
    private GeoRepository repository;

    public List<GeoResponse> findAll() {
        List<Geo> GeoList = repository.findAll();
        return generateGeoResponseList(GeoList);
    }

    public GeoResponse findById(Long id) {
        Optional<Geo> Geo = repository.findById(id);
        return Geo.map(GeoConverter::convertToGeoResponse).orElse(null);
    }

    public GeoResponse insert(GeoRequest GeoRequest) {
        Geo Geo = convertToGeo(GeoRequest);
        Geo = repository.save(Geo);
        return convertToGeoResponse(Geo);
    }

    public GeoResponse update(Long id, GeoRequest GeoRequest) {
        Geo Geo = convertToGeo(GeoRequest);
        Geo.setId(id);
        Geo updatedGeo = repository.save(Geo);
        return convertToGeoResponse(Geo);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
