package com.symptome.symptomechecker.persistence;

import com.symptome.symptomechecker.entity.Disease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseRepository extends JpaRepository<Disease,Long> {
  public Disease findByDisease(String name);
}
