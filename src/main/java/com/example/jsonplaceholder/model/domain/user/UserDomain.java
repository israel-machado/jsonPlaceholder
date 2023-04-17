package com.example.jsonplaceholder.model.domain.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private AddressDomain address;

    @OneToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private CompanyDomain company;
}
