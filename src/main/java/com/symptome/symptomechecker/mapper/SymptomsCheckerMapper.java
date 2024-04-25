package com.symptome.symptomechecker.mapper;

import com.symptome.symptomechecker.dto.SymptomsCheckerDto;
import com.symptome.symptomechecker.entity.SymptomsChecker;
import com.symptome.symptomechecker.mapper.MapperEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

public class SymptomsCheckerMapper implements MapperEntity<SymptomsCheckerDto, SymptomsChecker> {
    ModelMapper mapper=new ModelMapper();
    @Override
    public SymptomsCheckerDto convertToDto(SymptomsChecker entity) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return mapper.map(entity,SymptomsCheckerDto.class);
    }

    @Override
    public SymptomsChecker convertToEntity(SymptomsCheckerDto dto) {

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        return mapper.map(dto,SymptomsChecker.class);
    }

    @Override
    public List<SymptomsChecker> convertToEntity(List<SymptomsCheckerDto> dtoList) {
      List<SymptomsChecker>checkers=new ArrayList<>();
      dtoList.forEach(SymptomsCheckerDto -> {
          checkers.add(mapper.map(SymptomsCheckerDto,SymptomsChecker.class));
      });

        return checkers;
    }

    @Override
    public List<SymptomsCheckerDto> convertToDto(List<SymptomsChecker> entityList) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        List<SymptomsCheckerDto>dtos=new ArrayList<>();
        entityList.forEach(SymptomsChecker -> {
            dtos.add(mapper.map(SymptomsChecker,SymptomsCheckerDto.class));
        });

        return dtos;
    }
}
