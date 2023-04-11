package com.example.jsonplaceholder.controller.sup;

import com.example.jsonplaceholder.model.sup.Address;
import com.example.jsonplaceholder.services.sup.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService service;

    @GetMapping
    public List<Address> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Address create(@RequestBody Address address) {
        return service.save(address);
    }

    @PutMapping("/{id}")
    public Address update(@PathVariable Long id, @RequestBody Address address) {
        address.setId(id);
        return service.save(address);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
