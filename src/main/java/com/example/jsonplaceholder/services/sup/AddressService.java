package com.example.jsonplaceholder.services.sup;

import com.example.jsonplaceholder.client.JsonPlaceholderClient;
import com.example.jsonplaceholder.converters.sup.AddressConverter;
import com.example.jsonplaceholder.model.sup.Address;
import com.example.jsonplaceholder.model.dto.request.sup.AddressRequest;
import com.example.jsonplaceholder.model.dto.response.sup.AddressResponse;
import com.example.jsonplaceholder.model.sup.Geo;
import com.example.jsonplaceholder.repository.sup.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.example.jsonplaceholder.converters.sup.AddressConverter.*;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    private JsonPlaceholderClient jsonPlaceholderClient;

    public List<AddressResponse> findAll() {
        List<Address> addressList = repository.findAll();
        return generateAddressResponseList(addressList);
    }

    public AddressResponse findById(Long id) {
        Optional<Address> address = repository.findById(id);
        return address.map(AddressConverter::convertToAddressResponse).orElse(null);
    }

    public AddressResponse insert(AddressRequest addressRequest) {
        Address address = convertToAddress(addressRequest);
        address = repository.save(address);
        return convertToAddressResponse(address);
    }

    public AddressResponse update(Long id, AddressRequest addressRequest) {
        Address address = convertToAddress(addressRequest);
        address.setId(id);
        Address updatedAddress = repository.save(address);
        return convertToAddressResponse(updatedAddress);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
