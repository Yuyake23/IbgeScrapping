package com.ada.ibgeapi.dtos;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Distrito {
    @Id
    private Long id;
    private String nome;
    @ManyToOne
    @JoinColumn(name = "municipio_id")
    private Municipio municipio;
}
