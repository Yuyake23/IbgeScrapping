package com.ada.ibgeapi.services;

import com.ada.ibgeapi.dtos.MesoRegiao;
import com.ada.ibgeapi.dtos.Uf;
import com.ada.ibgeapi.repositories.MesoRegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MesoRegiaoService {

    @Autowired
    private MesoRegiaoRepository mesoRegiaoRepository;
    @Autowired
    private UfService ufService;

    public boolean existsById(Long id) {
        return this.mesoRegiaoRepository.existsById(id);
    }

    public MesoRegiao save(MesoRegiao entity) {
        Uf uf = entity.getUf();
        boolean ufExiste = this.ufService.existsById(uf.getId());

        if (!ufExiste) {
            entity.setUf(this.ufService.save(uf));
        }

        return this.mesoRegiaoRepository.save(entity);
    }
}
