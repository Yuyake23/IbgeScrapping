package com.ada.ibgeapi.services;

import com.ada.ibgeapi.dtos.Regiao;
import com.ada.ibgeapi.repositories.RegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegiaoService {

    @Autowired
    private RegiaoRepository regiaoRepository;

    public boolean existsById(Long id) {
        return this.regiaoRepository.existsById(id);
    }

    public Regiao save(Regiao entity) {
        return this.regiaoRepository.save(entity);
    }
}
