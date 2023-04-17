package com.example.jsonplaceholder.repository;

import com.example.jsonplaceholder.model.domain.PostDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostDomain, Long> {
}
