package com.mitocode.ProyectoFinalMitoCode.repository;

import com.mitocode.ProyectoFinalMitoCode.model.DetalleMatricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleMatriculaRepository extends JpaRepository<DetalleMatricula, Integer> {
}
