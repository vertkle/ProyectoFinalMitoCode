package com.mitocode.ProyectoFinalMitoCode.model.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetalleMatriculaDto {
    private Integer id;

    @NotEmpty
    @NotNull
    private String aula;

    @JsonBackReference
    private MatriculaDto matricula;

    @NotEmpty
    @NotNull
    private CursoDto curso;
}
