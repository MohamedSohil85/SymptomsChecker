package com.symptome.symptomechecker.mapper;

import com.symptome.symptomechecker.dto.SymptomsDTO;
import com.symptome.symptomechecker.entity.Symptoms;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class SymptomsMapper implements MapperEntity<SymptomsDTO, Symptoms> {
    ModelMapper mapper=new ModelMapper();

    @Override
    public SymptomsDTO convertToDto(Symptoms entity) {
        return mapper.map(entity,SymptomsDTO.class);
    }

    @Override
    public Symptoms convertToEntity(SymptomsDTO dto) {
        return mapper.map(dto,Symptoms.class);
    }

    @Override
    public List<Symptoms> convertToEntity(List<SymptomsDTO> dtoList) {
        List<Symptoms>symptoms=new ArrayList<>();
        dtoList.forEach(symptomsDTO -> {
            symptoms.add(mapper.map(symptomsDTO,Symptoms.class));
        });
        return symptoms;
    }

    @Override
    public List<SymptomsDTO> convertToDto(List<Symptoms> entityList) {

        List<SymptomsDTO>dtos=new ArrayList<>();
        entityList.forEach(symptoms -> {
            dtos.add(mapper.map(symptoms,SymptomsDTO.class));
        });
        return dtos;
    }
}
