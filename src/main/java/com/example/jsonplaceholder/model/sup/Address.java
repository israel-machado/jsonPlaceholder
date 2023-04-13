package com.example.jsonplaceholder.model.sup;

import com.example.jsonplaceholder.model.User;
import com.example.jsonplaceholder.model.dto.request.sup.AddressRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "addresses")
public class Address implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
    private User user;

    @OneToOne
    @JoinColumn(name = "geo_id", referencedColumnName = "id")
    private Geo geo;

}
