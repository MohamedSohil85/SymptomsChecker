package com.symptome.symptomechecker.dto;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class DiseaseDTO {
    private String disease;
    private String description;
}
