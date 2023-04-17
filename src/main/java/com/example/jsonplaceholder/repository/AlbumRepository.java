package com.example.jsonplaceholder.repository;

import com.example.jsonplaceholder.model.domain.AlbumDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumDomain, Long> {
}
