package com.mitocode.ProyectoFinalMitoCode.service;

import com.mitocode.ProyectoFinalMitoCode.model.Curso;
import com.mitocode.ProyectoFinalMitoCode.model.dto.CursoDto;
import com.mitocode.ProyectoFinalMitoCode.repository.CursoRepository;
import com.mitocode.ProyectoFinalMitoCode.service.interfaces.ICursoService;
import com.mitocode.ProyectoFinalMitoCode.utils.MapperClass;
import com.mitocode.ProyectoFinalMitoCode.utils.exceptions.ErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mitocode.ProyectoFinalMitoCode.utils.Constantes.EX_ERROR_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements ICursoService {

    private final CursoRepository repository;
    private final MapperClass<Curso, CursoDto> mapperClass;
    @Override
    public List<CursoDto> findAllService() {
        return repository.findAll()
                .stream()
                .map(curso -> mapperClass.entityToDto(curso, CursoDto.class))
                .toList();
    }

    @Override
    public CursoDto saveService(CursoDto cursoDto) {
        cursoDto.setEstado(true);
        return mapperClass
                .entityToDto(repository.save(mapperClass.dtoToEntity(cursoDto, Curso.class)), CursoDto.class);
    }

    @Override
    public CursoDto findByIdService(Integer id) throws ErrorException {
        return repository.findById(id)
                .map(curso -> mapperClass.entityToDto(curso, CursoDto.class))
                .orElseThrow(() -> new ErrorException(EX_ERROR_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    @Override
    public CursoDto update(CursoDto cursoDto, Integer id) throws ErrorException {
        findByIdService(id);
        cursoDto.setId(id);
        return mapperClass.entityToDto(repository.save(mapperClass.dtoToEntity(cursoDto, Curso.class)), CursoDto.class);
    }

    @Override
    public void delete(Integer id) throws ErrorException {
        findByIdService(id);
        repository.deleteById(id);
    }
}
