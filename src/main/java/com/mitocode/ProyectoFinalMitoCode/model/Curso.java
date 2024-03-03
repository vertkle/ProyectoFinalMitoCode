package com.mitocode.ProyectoFinalMitoCode.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombre",nullable = false, length = 150)
    private String nombre;
    @Column(name = "siglas",nullable = false, length = 4, unique = true)
    private String siglas;
    @Column(name = "estado",nullable = false)
    private Boolean estado;
}
