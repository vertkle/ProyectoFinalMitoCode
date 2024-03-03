package com.mitocode.ProyectoFinalMitoCode.repository;

import com.mitocode.ProyectoFinalMitoCode.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}
