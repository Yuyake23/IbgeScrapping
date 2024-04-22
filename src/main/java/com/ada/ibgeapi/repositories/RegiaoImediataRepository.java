package com.ada.ibgeapi.repositories;

import com.ada.ibgeapi.dtos.RegiaoImediata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegiaoImediataRepository extends JpaRepository<RegiaoImediata, Long> {
}
