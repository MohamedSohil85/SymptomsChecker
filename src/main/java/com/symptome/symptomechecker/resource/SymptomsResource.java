package com.symptome.symptomechecker.resource;

import com.symptome.symptomechecker.exception.ResourcesException;
import com.symptome.symptomechecker.service.SymptomsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
public class SymptomsResource {

    private SymptomsService service;

    public SymptomsResource(SymptomsService service) {
        this.service = service;
    }
    @PostMapping(value = "/readCSV",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity readfromFile() throws FileNotFoundException {
        return new ResponseEntity<>(service.readCSVFile(), HttpStatus.CREATED);
    }
    @GetMapping(value = "/symptom",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity loadAllDiseaseWithSymptoms(){
        return new ResponseEntity(service.showAllDisease(),HttpStatus.OK);
    }
    @GetMapping(value = "/findDiseases",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findDiseaseBySymptoms(@RequestParam("symptoms")String symptoms) throws ResourcesException {
        return new ResponseEntity(service.findDiseaseBySymptoms(symptoms),HttpStatus.FOUND);
    }
}
