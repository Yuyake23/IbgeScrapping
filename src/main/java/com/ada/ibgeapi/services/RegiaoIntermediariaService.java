package com.ada.ibgeapi.services;

import com.ada.ibgeapi.dtos.RegiaoIntermediaria;
import com.ada.ibgeapi.dtos.Uf;
import com.ada.ibgeapi.repositories.RegiaoIntermediariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegiaoIntermediariaService {

    @Autowired
    private RegiaoIntermediariaRepository regiaoIntermediariaRepository;
    @Autowired
    private UfService ufService;

    public boolean existsById(Long id) {
        return this.regiaoIntermediariaRepository.existsById(id);
    }

    public RegiaoIntermediaria save(RegiaoIntermediaria entity) {
        Uf uf = entity.getUf();
        boolean ufExiste = this.ufService.existsById(uf.getId());

        if (!ufExiste) {
            entity.setUf(this.ufService.save(uf));
        }

        return this.regiaoIntermediariaRepository.save(entity);
    }
}
