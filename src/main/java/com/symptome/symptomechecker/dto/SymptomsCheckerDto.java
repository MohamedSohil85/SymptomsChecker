package com.symptome.symptomechecker.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class SymptomsCheckerDto {

    private String disease;
    private String symptome;
    private String cures;
    private String doctors;
    private String riskLevel;
    private String description;
}
