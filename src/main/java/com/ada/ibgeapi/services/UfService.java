package com.ada.ibgeapi.services;

import com.ada.ibgeapi.dtos.Regiao;
import com.ada.ibgeapi.dtos.Uf;
import com.ada.ibgeapi.repositories.UfRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UfService {

    @Autowired
    private UfRepository ufRepository;
    @Autowired
    private RegiaoService regiaoService;

    public boolean existsById(Long id) {
        return this.ufRepository.existsById(id);
    }

    public Uf save(Uf entity) {
        Regiao regiao = entity.getRegiao();
        boolean ufExiste = this.regiaoService.existsById(regiao.getId());

        if (!ufExiste) {
            entity.setRegiao(this.regiaoService.save(regiao));
        }
        return this.ufRepository.save(entity);
    }
}
