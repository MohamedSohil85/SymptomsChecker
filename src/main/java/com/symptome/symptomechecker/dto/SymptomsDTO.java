package com.symptome.symptomechecker.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class SymptomsDTO {

    private int number;
    @CsvBindByName(column = "Disease")
    private String disease;
    @CsvBindByName(column = "Symptoms")
    private String symptoms;
}
