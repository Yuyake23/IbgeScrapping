package com.ada.ibgeapi.repositories;

import com.ada.ibgeapi.dtos.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
}
