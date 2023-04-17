package com.example.jsonplaceholder.repository;

import com.example.jsonplaceholder.model.domain.PhotoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoDomain, Long> {
}
