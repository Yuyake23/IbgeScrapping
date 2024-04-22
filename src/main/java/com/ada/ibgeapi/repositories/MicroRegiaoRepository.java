package com.ada.ibgeapi.repositories;

import com.ada.ibgeapi.dtos.MicroRegiao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MicroRegiaoRepository extends JpaRepository<MicroRegiao, Long> {
}
