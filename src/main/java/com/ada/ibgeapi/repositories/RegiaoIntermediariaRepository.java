package com.ada.ibgeapi.repositories;

import com.ada.ibgeapi.dtos.RegiaoIntermediaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiaoIntermediariaRepository extends JpaRepository<RegiaoIntermediaria, Long> {
}
