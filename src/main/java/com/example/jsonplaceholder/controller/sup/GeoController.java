package com.example.jsonplaceholder.controller.sup;

import com.example.jsonplaceholder.model.dto.request.sup.GeoRequest;
import com.example.jsonplaceholder.model.dto.response.sup.GeoResponse;
import com.example.jsonplaceholder.services.sup.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geos")
public class GeoController {

    @Autowired
    private GeoService service;

    @GetMapping
    public ResponseEntity<List<GeoResponse>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeoResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<GeoResponse> create(@RequestBody GeoRequest geoRequest){
        return new ResponseEntity<>(service.insert(geoRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeoResponse> update(@PathVariable Long id, @RequestBody GeoRequest geoRequest) {
       return ResponseEntity.ok().body(service.update(id, geoRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
