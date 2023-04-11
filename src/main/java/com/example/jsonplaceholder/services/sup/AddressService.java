package com.example.jsonplaceholder.services.sup;

import com.example.jsonplaceholder.model.sup.Address;
import com.example.jsonplaceholder.repository.sup.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> getAll() {
        return repository.findAll();
    }

    public Address getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Address save(Address address) {
        return repository.save(address);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
