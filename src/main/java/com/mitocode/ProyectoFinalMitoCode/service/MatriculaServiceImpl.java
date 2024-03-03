package com.mitocode.ProyectoFinalMitoCode.service;

import com.mitocode.ProyectoFinalMitoCode.model.Estudiante;
import com.mitocode.ProyectoFinalMitoCode.model.Matricula;
import com.mitocode.ProyectoFinalMitoCode.model.dto.EstudianteDto;
import com.mitocode.ProyectoFinalMitoCode.model.dto.MatriculaDto;
import com.mitocode.ProyectoFinalMitoCode.repository.DetalleMatriculaRepository;
import com.mitocode.ProyectoFinalMitoCode.repository.MatriculaRepository;
import com.mitocode.ProyectoFinalMitoCode.service.interfaces.IMatriculaService;
import com.mitocode.ProyectoFinalMitoCode.utils.MapperClass;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaServiceImpl implements IMatriculaService {
    private final MatriculaRepository repository;
    private final DetalleMatriculaRepository detalleMatriculaRepository;
    private final MapperClass<Matricula, MatriculaDto> mapper;
    private final MapperClass<Estudiante, EstudianteDto> mapperEstudiante;
    private final CursoServiceImpl cursoService;
    @Override
    public MatriculaDto saveService(MatriculaDto matriculaDto) {
        matriculaDto.setEstado(true);
        matriculaDto.setFechaMatricula(LocalDateTime.now());
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(matriculaDto, Matricula.class)), MatriculaDto.class);

    }

    @Override
    public Map<String, List<EstudianteDto>> getCursosEstudiantes() {
        return detalleMatriculaRepository.findAll()
                .stream()
                .collect(Collectors.groupingBy(detalleMatricula -> detalleMatricula.getCurso().getNombre(),
                        Collectors.mapping(detalleMatricula -> detalleMatricula.getMatricula().getEstudiante(),
                                Collectors.mapping(estudiante -> mapperEstudiante.entityToDto(estudiante, EstudianteDto.class),
                                        Collectors.toList()
                                )
                        )
                ));
    }
}
