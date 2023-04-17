package com.example.jsonplaceholder.repository.sup;

import com.example.jsonplaceholder.model.domain.user.CompanyDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyDomain, Long> {
}
