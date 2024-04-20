package com.ada.ibgeapi.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Regiao {
    @Id
    private Long id;
    private String sigla;
    private String nome;
}
