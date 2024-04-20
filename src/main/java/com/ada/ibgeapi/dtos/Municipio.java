package com.ada.ibgeapi.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Municipio {
    @Id
    @Column(name = "municipio_id")
    private Long id;
    private String nome;
    @JsonAlias("microrregiao")
    @ManyToOne
    @JoinColumn(name = "micro_regiao_id")
    private MicroRegiao microRegiao;
    @JsonAlias("regiao-imediata")
    @ManyToOne
    @JoinColumn(name = "regiao_imediata_id")
    private RegiaoImediata regiaoImediata;
}
