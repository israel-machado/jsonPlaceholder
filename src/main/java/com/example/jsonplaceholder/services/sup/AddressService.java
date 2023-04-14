package com.example.jsonplaceholder.services.sup;

import com.example.jsonplaceholder.converters.AddressConverter;
import com.example.jsonplaceholder.model.Address;
import com.example.jsonplaceholder.model.dto.request.AddressRequest;
import com.example.jsonplaceholder.model.dto.response.AddressResponse;
import com.example.jsonplaceholder.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.AddressConverter.*;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<AddressResponse> findAll() {
        List<Address> AddressList = repository.findAll();
        return generateAddressResponseList(AddressList);
    }

    public AddressResponse findById(Long id) {
        Optional<Address> Address = repository.findById(id);
        return Address.map(AddressConverter::convertToAddressResponse).orElse(null);
    }

    public AddressResponse insert(AddressRequest AddressRequest) {
        Address Address = convertToAddress(AddressRequest);
        Address = repository.save(Address);
        return convertToAddressResponse(Address);
    }

    public AddressResponse update(Long id, AddressRequest AddressRequest) {
        Address Address = convertToAddress(AddressRequest);
        Address.setId(id);
        Address updatedAddress = repository.save(Address);
        return convertToAddressResponse(Address);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
