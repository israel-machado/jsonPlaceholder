package com.example.jsonplaceholder.repository;

import com.example.jsonplaceholder.model.domain.user.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDomain, Long> {
}
