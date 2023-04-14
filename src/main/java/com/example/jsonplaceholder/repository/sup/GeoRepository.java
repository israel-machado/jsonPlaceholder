package com.example.jsonplaceholder.repository.sup;

import com.example.jsonplaceholder.model.sup.Geo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoRepository extends JpaRepository<Geo, Long> {
}
