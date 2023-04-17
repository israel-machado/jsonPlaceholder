package com.example.jsonplaceholder.repository.sup;

import com.example.jsonplaceholder.model.domain.user.AddressDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressDomain, Long> {
}
