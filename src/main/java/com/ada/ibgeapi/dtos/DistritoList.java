package com.ada.ibgeapi.dtos;

import jakarta.persistence.Entity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DistritoList {
    List<Distrito> distritos;

    public DistritoList() {
        this.distritos = new ArrayList<>();
    }
}
