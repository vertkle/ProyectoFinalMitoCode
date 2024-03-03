package com.mitocode.ProyectoFinalMitoCode.utils.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class ResponseErrorDto {
    private HttpStatus httpStatus;
    private List<String>messages;
}
