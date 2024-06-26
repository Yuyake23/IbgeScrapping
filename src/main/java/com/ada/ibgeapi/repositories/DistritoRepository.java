package com.ada.ibgeapi.repositories;

import com.ada.ibgeapi.dtos.Distrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistritoRepository extends JpaRepository<Distrito, Long> {
}
