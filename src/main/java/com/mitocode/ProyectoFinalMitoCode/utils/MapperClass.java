package com.mitocode.ProyectoFinalMitoCode.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperClass<E, D> {
    public E dtoToEntity(D dto, Class<E> entity){
        ModelMapper mp = new ModelMapper();
        return mp.map(dto, entity);
    }

    public D entityToDto(E entity, Class<D> dto){
        ModelMapper mp = new ModelMapper();
        return mp.map(entity, dto);
    }

}
