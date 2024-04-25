package com.symptome.symptomechecker.entity;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
public class Symptoms implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CsvBindByName(column = "id")
    private int number;
    @CsvBindByName(column = "Disease")
    private String disease;
    @CsvBindByName(column = "Symptoms")
    @Column(columnDefinition="TEXT", length = 1000)
    private String symptoms;
}
