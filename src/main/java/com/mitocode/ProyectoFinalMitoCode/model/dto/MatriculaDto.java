package com.mitocode.ProyectoFinalMitoCode.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MatriculaDto {
    private Integer id;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime fechaMatricula;


    @NotNull
    @JsonIncludeProperties(value = {"id"})
    private EstudianteDto estudiante;

    private Boolean estado;

    @NotNull
    @JsonManagedReference
    private List<DetalleMatriculaDto> detalleMatriculas;
}
