package com.mitocode.ProyectoFinalMitoCode.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.mitocode.ProyectoFinalMitoCode.utils.Constantes.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CursoDto {
    private Integer id;

    @NotNull(message = EX_ERROR_NOT_NULL)
    @NotEmpty(message = EX_ERROR_NOT_EMPTY)
    private String nombre;

    @NotNull(message = EX_ERROR_NOT_NULL)
    @NotEmpty(message = EX_ERROR_NOT_EMPTY)
    @Size(min = MIN_LENGHT_SIGLAS, max = MAX_LENGHT_SIGLAS, message = EX_MESSAGE_LENGHT_SIGLAS)
    private String siglas;

    private Boolean estado;

}
