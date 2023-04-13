package com.example.jsonplaceholder.model.dto.response;

import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.response.sup.AddressResponse;
import com.example.jsonplaceholder.model.dto.response.sup.CompanyResponse;

public class UserResponse {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private AddressResponse addressResponse;
    private CompanyResponse companyResponse;

    public UserResponse() {
    }

    public UserResponse(Long id, String name, String username, String email, String phone, String website, AddressResponse addressResponse, CompanyResponse companyResponse) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.addressResponse = addressResponse;
        this.companyResponse = companyResponse;
    }

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.phone = user.getPhone();
        this.website = user.getWebsite();
        this.addressResponse = new AddressResponse(user.getAddress());
        this.companyResponse = new CompanyResponse(user.getCompany());
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

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }

    public CompanyResponse getCompanyResponse() {
        return companyResponse;
    }

    public void setCompanyResponse(CompanyResponse companyResponse) {
        this.companyResponse = companyResponse;
    }
}
