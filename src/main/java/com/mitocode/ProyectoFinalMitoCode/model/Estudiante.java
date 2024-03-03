package com.mitocode.ProyectoFinalMitoCode.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "estudiante")
@Data
@NoArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "nombres",nullable = false, length = 150)
    private String nombres;
    @Column(name = "apellidos",nullable = false, length = 150)
    private String apellidos;
    @Column(name = "dni",nullable = false, length = 8, unique = true)
    private String dni;
    @Column(name = "edad", nullable = false, length = 3)
    private Short edad;
}
