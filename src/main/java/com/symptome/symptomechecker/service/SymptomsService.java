package com.symptome.symptomechecker.service;

import com.opencsv.bean.CsvToBeanBuilder;
import com.symptome.symptomechecker.dto.SymptomsDTO;
import com.symptome.symptomechecker.entity.Symptoms;
import com.symptome.symptomechecker.exception.ResourcesException;
import com.symptome.symptomechecker.mapper.SymptomsMapper;
import com.symptome.symptomechecker.persistence.SymptomsRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SymptomsService {

    private final SymptomsMapper symptomsMapper=new SymptomsMapper();
    private final SymptomsRepository symptomsRepository;

    public SymptomsService(SymptomsRepository symptomsRepository) {
        this.symptomsRepository = symptomsRepository;
    }

    public List<SymptomsDTO>readCSVFile() throws FileNotFoundException {
        List<Symptoms>symptoms=new CsvToBeanBuilder(new FileReader("C:\\Users\\momi_\\IdeaProjects\\demo2\\SymptomeChecker\\src\\main\\resources\\disease_symptoms.csv"))
                .withType(Symptoms.class).build().parse();
        symptomsRepository.saveAll(symptoms);
        List<SymptomsDTO>list=symptomsMapper.convertToDto(symptoms);
        return list;
    }

    public List<SymptomsDTO>showAllDisease(){
        List<Symptoms>symptoms=symptomsRepository.findAll(Sort.by("disease"));
        return symptomsMapper.convertToDto(symptoms);
    }
    public List<String>findDiseaseBySymptoms(String symptoms)throws ResourcesException{
        List<String>list= Arrays.asList(symptoms);
        List<String>list_= symptomsRepository.findAll().stream().filter(symptoms1 -> symptoms1.getSymptoms().equalsIgnoreCase(symptoms)).map(Symptoms::getDisease).toList();
        if (list.isEmpty()){
            new ResourcesException("List is empty");
        }
        return list_;
    }
}
