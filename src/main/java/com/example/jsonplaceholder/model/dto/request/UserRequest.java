package com.example.jsonplaceholder.model.dto.request;

import com.example.jsonplaceholder.model.dto.request.sup.AddressRequest;
import com.example.jsonplaceholder.model.dto.request.sup.CompanyRequest;
import com.example.jsonplaceholder.model.dto.response.sup.AddressResponse;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;

public class UserRequest {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private AddressRequest addressRequest;
    private CompanyRequest companyRequest;

    public UserRequest() {
    }

    public UserRequest(Long id, String name, String username, String email, String phone, String website, AddressRequest addressRequest, CompanyRequest companyRequest) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.addressRequest = addressRequest;
        this.companyRequest = companyRequest;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

    public void setAddressRequest(AddressRequest addressRequest) {
        this.addressRequest = addressRequest;
    }

    public CompanyRequest getCompanyRequest() {
        return companyRequest;
    }

    public void setCompanyRequest(CompanyRequest companyRequest) {
        this.companyRequest = companyRequest;
    }
}
