package com.example.jsonplaceholder.controller.sup;

import com.example.jsonplaceholder.model.dto.request.AddressRequest;
import com.example.jsonplaceholder.model.dto.response.AddressResponse;
import com.example.jsonplaceholder.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Addresss")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public ResponseEntity<List<AddressResponse>> findAll() {
        List<AddressResponse> AddressResponseList = service.findAll();
        return ResponseEntity.ok().body(AddressResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressResponse> findById(@PathVariable Long id) {
        AddressResponse AddressResponse = service.findById(id);
        return ResponseEntity.ok().body(AddressResponse);
    }

    @AddressMapping
    public ResponseEntity<AddressResponse> create(@RequestBody AddressRequest AddressRequest){
        AddressResponse AddressResponse = service.insert(AddressRequest);
        return new ResponseEntity<>(AddressResponse, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressResponse> update(@PathVariable Long id, @RequestBody AddressRequest AddressRequest) {
       AddressResponse AddressResponse = service.update(id, AddressRequest);
       return ResponseEntity.ok().body(AddressResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
