package com.symptome.symptomechecker.entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class SymptomsChecker implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CsvBindByName(column = "disease")
    private String disease;
    @CsvBindByName(column = "symptoms")
    private String symptome;
    @CsvBindByName(column = "cures")
    private String cures;
    @CsvBindByName(column = "doctor")
    private String doctors;
    @CsvBindByName(column = "risk level")
    private String riskLevel;



}
