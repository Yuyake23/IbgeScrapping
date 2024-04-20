package com.ada.ibgeapi.dtos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Uf {
    @Id
    private Long id;
    private String sigla;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "regiao_id")
    private Regiao regiao;
}
