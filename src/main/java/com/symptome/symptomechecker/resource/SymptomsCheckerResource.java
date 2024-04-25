package com.symptome.symptomechecker.resource;


import com.symptome.symptomechecker.dto.SymptomsCheckerDto;
import com.symptome.symptomechecker.exception.ResourcesException;
import com.symptome.symptomechecker.service.CheckerService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;

@RestController
public class SymptomsCheckerResource {
    private final CheckerService service;

    public SymptomsCheckerResource(CheckerService service) {
        this.service = service;
    }
    @RequestMapping(value = "/readFile_Symptoms",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public ResponseEntity addtoFile() throws IOException {
        return new ResponseEntity(service.readCSVFile(),HttpStatus.CREATED);
    }
    @RequestMapping(value = "/readFile_Description",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public ResponseEntity addToDatabase() throws FileNotFoundException {
        return new ResponseEntity<>(service.readCSVFile2(),HttpStatus.CREATED);
    }
    @RequestMapping(value = "/diseases",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public ResponseEntity findDiseaseBySymptom(@PathParam("symptoms")String symptoms) throws ResourcesException {
        return new ResponseEntity(service.findDiseaseBySymptoms(symptoms), HttpStatus.OK);
    }

    @RequestMapping(value = "/symptoms",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public ResponseEntity fetchSymptomsByDiseaseName(@PathParam("disease")String disease) throws ResourcesException {
        return new ResponseEntity(service.findSymptomsByDiseaseName(disease), HttpStatus.FOUND);
    }
    @RequestMapping(value = "/disease",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public ResponseEntity<SymptomsCheckerDto> addNewDisease(@RequestBody SymptomsCheckerDto SymptomsCheckerDto){
        return new ResponseEntity<>(service.addNewDisease(SymptomsCheckerDto), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/diseaseName",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public ResponseEntity<String>fetchAllDiseaseName(){
        return new ResponseEntity(service.findAllDisease(),HttpStatus.FOUND);
    }
    @RequestMapping(value = "delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.DELETE)
    public ResponseEntity deleteDiseaseById(@PathVariable("id")Long id){
        service.deleteDiseaseById(id);
        return new ResponseEntity("Disease has been deleted from Database !",HttpStatus.OK);
    }
    @RequestMapping(value = "/disease_description",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public ResponseEntity showDescriptionsOfDisease(){
        return new ResponseEntity(service.showListOfDiseases(),HttpStatus.FOUND);
    }}
