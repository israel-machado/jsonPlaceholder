package com.example.jsonplaceholder.model.dto.request;

import com.example.jsonplaceholder.model.dto.request.sup.AddressRequest;
import com.example.jsonplaceholder.model.dto.request.sup.CompanyRequest;
import com.example.jsonplaceholder.model.dto.response.sup.AddressResponse;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private AddressRequest addressRequest;
    private CompanyRequest companyRequest;
}
