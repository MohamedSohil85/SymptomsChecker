package com.symptome.symptomechecker.mapper;

import com.symptome.symptomechecker.dto.DiseaseDTO;
import com.symptome.symptomechecker.entity.Disease;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

public class DiseaseMapper implements MapperEntity<DiseaseDTO,Disease> {
    ModelMapper mapper=new ModelMapper();
    @Override
    public DiseaseDTO convertToDto(Disease entity) {
        return mapper.map(entity,DiseaseDTO.class);
    }

    @Override
    public Disease convertToEntity(DiseaseDTO dto) {
        return mapper.map(dto,Disease.class);
    }

    @Override
    public List<Disease> convertToEntity(List<DiseaseDTO> dtoList) {
        return null;
    }

    @Override
    public List<DiseaseDTO> convertToDto(List<Disease> entityList) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        List<DiseaseDTO>dtoList=new ArrayList<>();
        entityList.forEach(disease -> {
            dtoList.add(mapper.map(disease,DiseaseDTO.class));
        });
        return dtoList;
    }
}
