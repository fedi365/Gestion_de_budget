package org.example.gestion_de_budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.gestion_de_budget.model.Depense;
import org.springframework.stereotype.Repository;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Long> {

}
