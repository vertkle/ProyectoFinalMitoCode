package com.mitocode.ProyectoFinalMitoCode.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "detalle_matricula")
@Data
@NoArgsConstructor
public class DetalleMatricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "aula", nullable = false, length = 100)
    private String aula;
    @ManyToOne
    @JoinColumn(name = "fk_matricula", nullable = false)
    private Matricula matricula;
    @ManyToOne
    @JoinColumn(name = "fk_curso", nullable = false)
    private Curso curso;
}
