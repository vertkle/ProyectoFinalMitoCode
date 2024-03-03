package com.mitocode.ProyectoFinalMitoCode.controller;

import com.mitocode.ProyectoFinalMitoCode.model.dto.EstudianteDto;
import com.mitocode.ProyectoFinalMitoCode.model.dto.MatriculaDto;
import com.mitocode.ProyectoFinalMitoCode.service.MatriculaServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/matricula")
@RequiredArgsConstructor
public class MatriculaController {
    private final MatriculaServiceImpl service;

    @PostMapping
    public ResponseEntity<MatriculaDto>save(@Valid @RequestBody MatriculaDto matriculaDto){
        return new ResponseEntity<>(service.saveService(matriculaDto), HttpStatus.CREATED);
    }
    @GetMapping("/curso-estudiantes")
    public ResponseEntity<Map<String, List<EstudianteDto>>>getCursoEstudiantes(){
        return ResponseEntity.ok(service.getCursosEstudiantes());
    }
}
