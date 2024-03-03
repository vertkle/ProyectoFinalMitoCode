package com.mitocode.ProyectoFinalMitoCode.repository;

import com.mitocode.ProyectoFinalMitoCode.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {
}
