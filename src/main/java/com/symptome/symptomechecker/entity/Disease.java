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
public class Disease implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CsvBindByName(column = "disease")
    private String disease;
    @CsvBindByName(column = "description")
    @Column(columnDefinition="TEXT", length = 1000)
    private String description;

}
