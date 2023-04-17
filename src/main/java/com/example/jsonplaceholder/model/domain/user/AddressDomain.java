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
@Table(name = "addresses")
public class AddressDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private UserDomain user;

    @OneToOne
    @JoinColumn(name = "geo_id", referencedColumnName = "id")
    private GeoDomain geo;

}
