package com.symptome.symptomechecker.persistence;

import com.symptome.symptomechecker.entity.SymptomsChecker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SymptomsCheckerRepository extends JpaRepository<SymptomsChecker,Long> {
    Optional <SymptomsChecker>findByDisease(String name);

}
