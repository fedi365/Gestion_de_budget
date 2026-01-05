package org.example.gestion_de_budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.gestion_de_budget.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
