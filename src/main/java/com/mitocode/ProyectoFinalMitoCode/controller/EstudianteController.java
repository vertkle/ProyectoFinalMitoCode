package com.mitocode.ProyectoFinalMitoCode.controller;

import com.mitocode.ProyectoFinalMitoCode.model.dto.EstudianteDto;
import com.mitocode.ProyectoFinalMitoCode.service.EstudianteServiceImpl;
import com.mitocode.ProyectoFinalMitoCode.utils.exceptions.ErrorException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiante")
@RequiredArgsConstructor
public class EstudianteController {
    private final EstudianteServiceImpl service;

    @GetMapping
    public ResponseEntity<List<EstudianteDto>>findAll(){
        return ResponseEntity.ok(service.findAllService());
    }
    @PostMapping
    public ResponseEntity<EstudianteDto>save(@Valid @RequestBody EstudianteDto estudianteDto){
        return new ResponseEntity<>(service.saveService(estudianteDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDto>update(@Valid @RequestBody EstudianteDto estudianteDto, @PathVariable("id") Integer id ) throws ErrorException {
        return new ResponseEntity<>(service.update(estudianteDto, id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto>findById(@PathVariable("id") Integer id ) throws ErrorException {
        return new ResponseEntity<>(service.findByIdService(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable("id") Integer id) throws ErrorException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/desc-edad")
    public ResponseEntity<List<EstudianteDto>>findAllOrder(){
        return ResponseEntity.ok(service.findAllOrderEdadDescService());
    }
}
