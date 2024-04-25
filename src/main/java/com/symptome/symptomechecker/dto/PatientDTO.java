package com.symptome.symptomechecker.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class PatientDTO {

    private String patientName;
    private String patientLastName;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfBirth;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateOfInfection;
    private String disease;
    private String symptome;
    private String cures;
}
