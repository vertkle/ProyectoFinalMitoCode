package com.mitocode.ProyectoFinalMitoCode.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "matricula")
@Getter
@Setter
@NoArgsConstructor
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "fecha_matricula", nullable = false)
    private LocalDateTime fechaMatricula;
    @ManyToOne
    @JoinColumn(name = "fk_estudiante", nullable = false)
    private Estudiante estudiante;
    @Column(name = "estado", nullable = false)
    private Boolean estado = true;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<DetalleMatricula> detalleMatriculas;
}
