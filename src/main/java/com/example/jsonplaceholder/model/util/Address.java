package com.example.jsonplaceholder.model.util;

import com.example.jsonplaceholder.model.User;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    private Long id;
    private String street;
    private String suite;
    private String city;
    private String zipcode;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Embedded
    private Geo geo;

    public Address() {
    }

    public Address(Long id, String street, String suite, String city, String zipcode, Geo geo) {
        this.id = id;
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }
}
