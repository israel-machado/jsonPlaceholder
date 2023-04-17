package com.example.jsonplaceholder.repository;

import com.example.jsonplaceholder.model.domain.TodoDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoDomain, Long> {
}
