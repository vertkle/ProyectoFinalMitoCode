package com.mitocode.ProyectoFinalMitoCode.repository;

import com.mitocode.ProyectoFinalMitoCode.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
}
