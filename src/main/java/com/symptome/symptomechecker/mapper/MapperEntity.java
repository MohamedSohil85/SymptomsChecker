package com.symptome.symptomechecker.mapper;

import java.util.List;

public interface MapperEntity <D,E>{
    public D convertToDto(E entity);
    public E convertToEntity(D dto);
    public List<E>convertToEntity(List<D>dtoList);
    public List<D>convertToDto(List<E> entityList);
}
