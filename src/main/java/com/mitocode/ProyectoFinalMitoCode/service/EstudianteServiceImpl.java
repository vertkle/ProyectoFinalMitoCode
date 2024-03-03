package com.mitocode.ProyectoFinalMitoCode.service;

import com.mitocode.ProyectoFinalMitoCode.model.Estudiante;
import com.mitocode.ProyectoFinalMitoCode.model.dto.EstudianteDto;
import com.mitocode.ProyectoFinalMitoCode.repository.EstudianteRepository;
import com.mitocode.ProyectoFinalMitoCode.service.interfaces.IEstudianteService;
import com.mitocode.ProyectoFinalMitoCode.utils.MapperClass;
import com.mitocode.ProyectoFinalMitoCode.utils.exceptions.ErrorException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static com.mitocode.ProyectoFinalMitoCode.utils.Constantes.EX_ERROR_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class EstudianteServiceImpl implements IEstudianteService {
    private final EstudianteRepository repository;
    private final MapperClass<Estudiante, EstudianteDto> mapper;
    @Override
    public List<EstudianteDto> findAllService() {
        return repository.findAll()
                .stream()
                .map(estudiante -> mapper.entityToDto(estudiante, EstudianteDto.class))
                .toList();
    }

    @Override
    public EstudianteDto saveService(EstudianteDto estudianteDto) {
        return mapper
                .entityToDto(repository.save(mapper.dtoToEntity(estudianteDto, Estudiante.class)), EstudianteDto.class);
    }

    @Override
    public EstudianteDto findByIdService(Integer id) throws ErrorException {
        return repository.findById(id)
                .map(estudiante -> mapper.entityToDto(estudiante, EstudianteDto.class))
                .orElseThrow(() -> new ErrorException(EX_ERROR_NOT_FOUND, HttpStatus.NOT_FOUND));
    }

    @Override
    public EstudianteDto update(EstudianteDto estudianteDto, Integer id) throws ErrorException {
        findByIdService(id);
        estudianteDto.setId(id);
        return mapper.entityToDto(repository.save(mapper.dtoToEntity(estudianteDto, Estudiante.class)), EstudianteDto.class);
    }

    @Override
    public void delete(Integer id) throws ErrorException {
        findByIdService(id);
        repository.deleteById(id);
    }

    @Override
    public List<EstudianteDto> findAllOrderEdadDescService() {
        return repository.findAll()
                .stream()
                .map(estudiante -> mapper.entityToDto(estudiante, EstudianteDto.class))
                .sorted(Comparator.comparingInt(EstudianteDto::getEdad).reversed())
                .toList();

    }
}
