package com.ada.ibgeapi.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class MicroRegiao {
    @Id
    private Long id;
    private String nome;
    @JsonAlias("mesorregiao")
    @ManyToOne
    @JoinColumn(name = "meso_regiao_id")
    private MesoRegiao mesoRegiao;
}
