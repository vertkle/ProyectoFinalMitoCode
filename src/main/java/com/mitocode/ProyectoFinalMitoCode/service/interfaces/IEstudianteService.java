package com.mitocode.ProyectoFinalMitoCode.service.interfaces;

import com.mitocode.ProyectoFinalMitoCode.model.dto.EstudianteDto;
import com.mitocode.ProyectoFinalMitoCode.utils.exceptions.ErrorException;

import java.util.List;

public interface IEstudianteService {
    List<EstudianteDto> findAllService();
    EstudianteDto saveService(EstudianteDto estudianteDto);
    EstudianteDto findByIdService(Integer id) throws ErrorException;
    EstudianteDto update(EstudianteDto estudianteDto, Integer id) throws ErrorException;
    void delete(Integer id) throws ErrorException;
    List<EstudianteDto> findAllOrderEdadDescService();
}
