package com.mitocode.ProyectoFinalMitoCode.service.interfaces;

import com.mitocode.ProyectoFinalMitoCode.model.dto.CursoDto;

import java.util.List;

public interface ICursoService {
    List<CursoDto>findAllService();
    CursoDto saveService(CursoDto cursoDto);
    CursoDto findByIdService(Integer id) throws Exception;
    CursoDto update(CursoDto cursoDto, Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
