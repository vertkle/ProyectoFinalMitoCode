package com.mitocode.ProyectoFinalMitoCode.controller;

import com.mitocode.ProyectoFinalMitoCode.model.dto.CursoDto;
import com.mitocode.ProyectoFinalMitoCode.service.CursoServiceImpl;
import com.mitocode.ProyectoFinalMitoCode.utils.exceptions.ErrorException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/curso")
@RequiredArgsConstructor
public class CursoController {
    private final CursoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<CursoDto>> findAll(){
        return ResponseEntity.ok(service.findAllService());
    }
    @PostMapping
    public ResponseEntity<CursoDto>save(@Valid @RequestBody CursoDto cursoDto){
        return new ResponseEntity<>(service.saveService(cursoDto), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CursoDto>update(@RequestBody CursoDto cursoDto, @PathVariable Integer id ) throws ErrorException {
        return new ResponseEntity<>(service.update(cursoDto, id), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoDto>findById(@PathVariable Integer id ) throws ErrorException {
        return new ResponseEntity<>(service.findByIdService(id), HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Integer id) throws ErrorException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
