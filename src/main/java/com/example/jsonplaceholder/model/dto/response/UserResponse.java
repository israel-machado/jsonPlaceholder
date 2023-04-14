package com.example.jsonplaceholder.model.dto.response;

import com.example.jsonplaceholder.model.User;
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
public class UserResponse {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private AddressResponse addressResponse;
    private CompanyResponse companyResponse;
}
