package com.symptome.symptomechecker.service;

import com.symptome.symptomechecker.dto.PatientDTO;
import com.symptome.symptomechecker.entity.Patient;
import com.symptome.symptomechecker.entity.SymptomsChecker;
import com.symptome.symptomechecker.exception.ResourcesException;
import com.symptome.symptomechecker.mapper.PatientMapper;
import com.symptome.symptomechecker.persistence.PatientRepository;
import com.symptome.symptomechecker.persistence.SymptomsCheckerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PatientService {

    private final PatientMapper patientMapper=new PatientMapper();
    private final PatientRepository patientRepository;
    private final SymptomsCheckerRepository symptomsCheckerRepository;

    public PatientService(PatientRepository patientRepository, SymptomsCheckerRepository symptomsCheckerRepository) {
        this.patientRepository = patientRepository;
        this.symptomsCheckerRepository = symptomsCheckerRepository;
    }
    public PatientDTO findPatientDisease(String diseaseName,PatientDTO patientDTO) throws ResourcesException {
        Optional<SymptomsChecker>symptomsChecker=symptomsCheckerRepository.findByDisease(diseaseName);
        SymptomsChecker symptomsChecker_=symptomsChecker.orElseThrow(()->new ResourcesException("Disease Not found"));
        patientDTO.setDateOfInfection(LocalDate.now());
        Patient patient=patientMapper.convertToEntity(patientDTO);
        patient.setSymptomsChecker(symptomsChecker_);
        patientRepository.save(patient);
        return patientDTO;

    }

    public List<SymptomsChecker>fetchListOfPatients(String lastName,String firstName,LocalDate dateOfBirth){
        Predicate<Patient>patientPredicate=patient -> patient.getPatientLastName().equalsIgnoreCase(lastName)&&patient.getPatientName().equalsIgnoreCase(firstName)&&patient.getDateOfBirth().equals(dateOfBirth);
        return patientRepository.findAll().stream().filter(patientPredicate).map(Patient::getSymptomsChecker).collect(Collectors.toList());
    }

}
