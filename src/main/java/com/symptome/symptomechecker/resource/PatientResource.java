package com.symptome.symptomechecker.resource;

import com.symptome.symptomechecker.dto.PatientDTO;
import com.symptome.symptomechecker.exception.ResourcesException;
import com.symptome.symptomechecker.service.PatientService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
public class PatientResource {

    private final PatientService service;

    public PatientResource(PatientService service) {
        this.service = service;
    }

    @PostMapping(value = "/patient/{disease}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPatient(@PathVariable("disease")String disease, @RequestBody PatientDTO patientDTO) throws ResourcesException {
        return new ResponseEntity<>(service.findPatientDisease(disease, patientDTO), HttpStatus.CREATED);
    }
    @GetMapping(value = "/patient",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity showPatientsSymptoms(@RequestParam("lastName")String lastName, @RequestParam("firstName")String firstName, @RequestParam("dateOfBirth")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE,pattern = "dd/MM/yyyy")LocalDate dateOfBirth){
        return new ResponseEntity(service.fetchListOfPatients(lastName, firstName, dateOfBirth),HttpStatus.FOUND);
    }

}
