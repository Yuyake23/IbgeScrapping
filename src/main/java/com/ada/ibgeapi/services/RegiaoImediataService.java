package com.ada.ibgeapi.services;

import com.ada.ibgeapi.dtos.RegiaoImediata;
import com.ada.ibgeapi.dtos.RegiaoIntermediaria;
import com.ada.ibgeapi.repositories.RegiaoImediataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegiaoImediataService {

    @Autowired
    private RegiaoImediataRepository regiaoImediataRepository;
    @Autowired
    private RegiaoIntermediariaService regiaoIntermediariaService;

    public boolean existsById(Long id) {
        return this.regiaoImediataRepository.existsById(id);
    }

    public RegiaoImediata save(RegiaoImediata entity) {
        RegiaoIntermediaria regiaoIntermediaria = entity.getRegiaoIntermediaria();
        boolean regiaoIntermediariaExiste = this.regiaoIntermediariaService.existsById(entity.getId());

        if (!regiaoIntermediariaExiste) {
            entity.setRegiaoIntermediaria(this.regiaoIntermediariaService.save(regiaoIntermediaria));
        }

        return this.regiaoImediataRepository.save(entity);
    }
}
