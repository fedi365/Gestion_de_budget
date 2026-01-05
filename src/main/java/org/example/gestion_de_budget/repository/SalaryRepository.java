package org.example.gestion_de_budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.gestion_de_budget.model.Salary;
import org.example.gestion_de_budget.model.User;
import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    List<Salary> findByUser(User user);

}
