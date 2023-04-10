package com.example.jsonplaceholder.repository.sup;

import com.example.jsonplaceholder.model.sup.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
