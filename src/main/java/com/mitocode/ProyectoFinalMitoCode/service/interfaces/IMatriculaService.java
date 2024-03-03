package com.mitocode.ProyectoFinalMitoCode.service.interfaces;

import com.mitocode.ProyectoFinalMitoCode.model.dto.EstudianteDto;
import com.mitocode.ProyectoFinalMitoCode.model.dto.MatriculaDto;

import java.util.List;
import java.util.Map;

public interface IMatriculaService {
    MatriculaDto saveService(MatriculaDto matriculaDto);
    Map<String, List<EstudianteDto>> getCursosEstudiantes();
}
