package com.symptome.symptomechecker.service;

import com.opencsv.bean.CsvToBeanBuilder;


import com.symptome.symptomechecker.dto.DiseaseDTO;
import com.symptome.symptomechecker.dto.SymptomsCheckerDto;
import com.symptome.symptomechecker.entity.Disease;
import com.symptome.symptomechecker.entity.SymptomsChecker;
import com.symptome.symptomechecker.exception.ResourcesException;
import com.symptome.symptomechecker.mapper.DiseaseMapper;
import com.symptome.symptomechecker.mapper.SymptomsCheckerMapper;
import com.symptome.symptomechecker.persistence.DiseaseRepository;
import com.symptome.symptomechecker.persistence.SymptomsCheckerRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CheckerService {
    private final DiseaseMapper diseaseMapper=new DiseaseMapper();
    private final SymptomsCheckerMapper mapper = new SymptomsCheckerMapper();
    private final SymptomsCheckerRepository repository;
    private final DiseaseRepository diseaseRepository;
    public CheckerService(SymptomsCheckerRepository repository, DiseaseRepository diseaseRepository) {
        this.repository = repository;
        this.diseaseRepository = diseaseRepository;
    }

    public List<SymptomsChecker> readCSVFile() throws IOException {
        // Path path=Path.of("C:\\Users\\momi_\\IdeaProjects\\demo2\\SymptomsChecker\\src\\main\\resources\\disease_symptom.csv");
        List<SymptomsChecker> checkers = new CsvToBeanBuilder(new FileReader("C:\\Users\\momi_\\IdeaProjects\\demo2\\SymptomeChecker\\src\\main\\resources\\dataset.csv"))
                .withType(SymptomsChecker.class).build().parse();
        repository.saveAll(checkers);
        return checkers;

    }
    public List<Disease>readCSVFile2() throws FileNotFoundException {
        List<Disease> checkers=new CsvToBeanBuilder(new FileReader("C:\\Users\\momi_\\IdeaProjects\\demo2\\SymptomeChecker\\src\\main\\resources\\symptom_Description.csv"))
                .withType(Disease.class).build().parse();
        diseaseRepository.saveAll(checkers);
        return checkers;
    }

    // add new Disease with symptoms
    // change Disease Details by Id
    // show Disease Details by Name



   public List<String>findDiseaseBySymptoms(String symptoms) throws ResourcesException {
    List<String>diseases=repository.findAll().stream().filter(s -> s.getSymptome().contains(symptoms)).map(SymptomsChecker::getDisease).collect(Collectors.toList());
    if (diseases.isEmpty()){
        throw new ResourcesException("No Disease is found");
    }
    return diseases;
   }
   public SymptomsCheckerDto findSymptomsByDiseaseName(String name) throws ResourcesException {
        Optional<SymptomsChecker> SymptomsChecker=repository.findAll().stream().filter(SymptomsChecker1 -> SymptomsChecker1.getDisease().equalsIgnoreCase(name)).findAny();
        SymptomsChecker SymptomsChecker_= SymptomsChecker.orElseThrow(()->new ResourcesException("not found !"));
        return mapper.convertToDto(SymptomsChecker_);
   }
  public SymptomsCheckerDto addNewDisease(SymptomsCheckerDto dto){
        SymptomsChecker SymptomsChecker=mapper.convertToEntity(dto);
        repository.save(SymptomsChecker);
        return dto;
  }
  public List<String>findAllDisease(){
        List<String>list=repository
                .findAll()
                .stream()
                .map(SymptomsChecker::getDisease)
                .collect(Collectors.toList());
        return list;
  }
  public void deleteDiseaseById(Long id){

        repository.deleteById(id);
  }
  public List<DiseaseDTO>showListOfDiseases(){
        List<Disease>diseases=diseaseRepository.findAll(Sort.by("disease"));
        List<DiseaseDTO>dtoList=diseaseMapper.convertToDto(diseases);
        return dtoList;
  }
}
