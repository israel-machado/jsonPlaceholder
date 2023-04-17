package com.example.jsonplaceholder.model.placeholder.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPlaceholder {

    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    private AddressPlaceholder address;

    private CompanyPlaceholder company;
}
