package com.mitocode.ProyectoFinalMitoCode.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.mitocode.ProyectoFinalMitoCode.utils.Constantes.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteDto {
    private Integer id;

    @NotNull(message = EX_ERROR_NOT_NULL)
    @NotEmpty(message = EX_ERROR_NOT_EMPTY)
    private String nombres;

    @NotNull(message = EX_ERROR_NOT_NULL)
    @NotEmpty(message = EX_ERROR_NOT_EMPTY)
    private String apellidos;

    @NotNull(message = EX_ERROR_NOT_NULL)
    @NotEmpty(message = EX_ERROR_NOT_EMPTY)
    @Size(min = 8, max = 8, message = EX_MESSAGE_LENGHT_DNI)
    private String dni;

    @NotNull(message = EX_ERROR_NOT_NULL)
    @Min(value = 10, message = EX_AGE_MIN_ESTUDIANTE)
    private Short edad;

}
