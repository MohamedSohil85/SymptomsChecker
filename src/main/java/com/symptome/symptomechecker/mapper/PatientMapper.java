package com.symptome.symptomechecker.mapper;

import com.symptome.symptomechecker.dto.PatientDTO;
import com.symptome.symptomechecker.entity.Patient;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

public class PatientMapper implements MapperEntity<PatientDTO, Patient> {
    ModelMapper mapper=new ModelMapper();
    @Override
    public PatientDTO convertToDto(Patient entity) {
        return mapper.map(entity,PatientDTO.class);
    }

    @Override
    public Patient convertToEntity(PatientDTO dto) {
        return mapper.map(dto,Patient.class);
    }

    @Override
    public List<Patient> convertToEntity(List<PatientDTO> dtoList) {

        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        List<Patient>patients=new ArrayList<>();
        dtoList.forEach(patientDTO -> {
            patients.add(mapper.map(patientDTO,Patient.class));
        });
        return patients;
    }

    @Override
    public List<PatientDTO> convertToDto(List<Patient> entityList) {
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        List<PatientDTO>dtoList=new ArrayList<>();
        entityList.forEach(patient -> {
            dtoList.add(mapper.map(patient,PatientDTO.class));
        });
        return dtoList;
    }
}
