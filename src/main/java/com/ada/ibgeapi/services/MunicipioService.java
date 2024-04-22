package com.ada.ibgeapi.services;

import com.ada.ibgeapi.dtos.MicroRegiao;
import com.ada.ibgeapi.dtos.Municipio;
import com.ada.ibgeapi.dtos.RegiaoImediata;
import com.ada.ibgeapi.repositories.MunicipioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository municipioRepository;
    @Autowired
    private MicroRegiaoService microRegiaoService;
    @Autowired
    private RegiaoImediataService regiaoImediataService;

    public boolean existsById(Long id) {
        return this.municipioRepository.existsById(id);
    }

    public Municipio save(Municipio entity) {
        MicroRegiao microRegiao = entity.getMicroRegiao();
        RegiaoImediata regiaoImediata = entity.getRegiaoImediata();
        boolean microRegiaoExiste = this.microRegiaoService.existsById(microRegiao.getId());
        boolean regiaoImediataExiste = this.regiaoImediataService.existsById(regiaoImediata.getId());

        if (!microRegiaoExiste) {
            entity.setMicroRegiao(this.microRegiaoService.save(microRegiao));
        }
        if (!regiaoImediataExiste) {
            entity.setRegiaoImediata(this.regiaoImediataService.save(regiaoImediata));
        }

        return this.municipioRepository.save(entity);
    }
}
