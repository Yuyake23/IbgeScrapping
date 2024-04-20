package com.ada.ibgeapi.services;

import com.ada.ibgeapi.dtos.Municipio;
import org.springframework.stereotype.Service;

@Service
public class MunicipioService {

    public boolean existsById(long municipioId) {
        return false;
    }

    public Municipio save(Municipio municipio) {
        return null;
    }
}
