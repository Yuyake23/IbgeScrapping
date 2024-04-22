package com.ada.ibgeapi.services;

import com.ada.ibgeapi.dtos.MesoRegiao;
import com.ada.ibgeapi.dtos.MicroRegiao;
import com.ada.ibgeapi.repositories.MicroRegiaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MicroRegiaoService {

    @Autowired
    private MicroRegiaoRepository microRegiaoRepository;
    @Autowired
    private MesoRegiaoService mesoRegiaoService;

    public boolean existsById(Long id) {
        return this.microRegiaoRepository.existsById(id);
    }

    public MicroRegiao save(MicroRegiao entity) {
        MesoRegiao mesoRegiao = entity.getMesoRegiao();
        boolean mesoRegiaoExiste = this.mesoRegiaoService.existsById(mesoRegiao.getId());

        if (!mesoRegiaoExiste) {
            entity.setMesoRegiao(this.mesoRegiaoService.save(mesoRegiao));
        }

        return this.microRegiaoRepository.save(entity);
    }
}
