package com.ada.ibgeapi.repositories;

import com.ada.ibgeapi.dtos.MesoRegiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MesoRegiaoRepository extends JpaRepository<MesoRegiao, Long> {
}
