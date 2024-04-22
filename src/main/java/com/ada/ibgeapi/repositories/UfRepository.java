package com.ada.ibgeapi.repositories;

import com.ada.ibgeapi.dtos.Uf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UfRepository extends JpaRepository<Uf, Long> {
}
