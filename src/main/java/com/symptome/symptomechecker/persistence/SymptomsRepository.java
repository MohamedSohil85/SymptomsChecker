package com.symptome.symptomechecker.persistence;

import com.symptome.symptomechecker.entity.Symptoms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomsRepository extends JpaRepository<Symptoms,Long> {
}
