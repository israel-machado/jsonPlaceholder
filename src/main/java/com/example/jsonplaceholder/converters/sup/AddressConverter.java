package com.example.jsonplaceholder.converters.sup;

import com.example.jsonplaceholder.model.Address;
import com.example.jsonplaceholder.model.dto.request.AddressRequest;
import com.example.jsonplaceholder.model.dto.response.AddressResponse;
import com.example.jsonplaceholder.model.dto.response.sup.AddressResponse;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;
import com.example.jsonplaceholder.model.sup.Address;
import com.example.jsonplaceholder.model.sup.Company;

import java.util.List;
import java.util.stream.Collectors;

public class AddressConverter {

    public static Address convertToAddress(AddressRequest AddressRequest) {



    }

    public static AddressResponse convertToAddressResponse(Address Address) {


    }

    public static List<AddressResponse> generateAddressResponseList(List<Address> AddressList) {
        List<AddressResponse> AddressResponseList = AddressList.stream()
                .map(AddressConverter::convertToAddressResponse)
                .collect(Collectors.toList());
        return AddressResponseList;
    }
}
