package com.ada.ibgeapi.services;

import com.ada.ibgeapi.dtos.Distrito;
import com.ada.ibgeapi.dtos.Municipio;
import com.ada.ibgeapi.repositories.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DistritoService {
    private static final String URL = "https://servicodados.ibge.gov.br";
    private static final String URI_DISTRITOS = "/api/v1/localidades/microrregioes/{codigoIbge}/distritos";

    @Autowired
    private DistritoRepository distritoRepository;
    @Autowired
    private MunicipioService municipioService;

    public List<Distrito> consultarDistritos(String codigoIbge) {
        Distrito[] distritos = WebClient
                .create(URL)
                .get()
                .uri(URI_DISTRITOS, codigoIbge)
                .retrieve()
                .bodyToMono(Distrito[].class)
                .block();

        return List.of(Objects.requireNonNull(distritos));
    }

    public List<Distrito> sugarDistritos(String codigoIbge) {
        List<Distrito> distritos = this.consultarDistritos(codigoIbge);
        return this.saveAll(distritos);
    }

    public Distrito save(Distrito entity) {
        Municipio municipio = entity.getMunicipio();
        boolean municipioExiste = this.municipioService.existsById(municipio.getId());

        if (!municipioExiste) {
            entity.setMunicipio(this.municipioService.save(municipio));
        }

        return this.distritoRepository.save(entity);
    }

    public List<Distrito> saveAll(List<Distrito> entities) {
        return entities.stream()
                .map(this::save)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
