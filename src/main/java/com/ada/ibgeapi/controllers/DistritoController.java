package com.ada.ibgeapi.controllers;

import com.ada.ibgeapi.dtos.Distrito;
import com.ada.ibgeapi.services.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/distrito")
public class DistritoController {
    @Autowired
    private DistritoService distritoService;

    @GetMapping("/{codigoIbge}")
    @ResponseStatus(HttpStatus.OK)
    public List<Distrito> consultarDistritosWebFlux(@PathVariable String codigoIbge) {
        List<Distrito> distritos = distritoService.consultarDistritos(codigoIbge);
        return distritos;
    }

    @PostMapping("/{codigoIbge}")
    @ResponseStatus(HttpStatus.OK)
    public List<Distrito> sugarDistritosWebFlux(@PathVariable String codigoIbge) {
        List<Distrito> distritos = distritoService.sugarDistritos(codigoIbge);
        return distritos;
    }
}
