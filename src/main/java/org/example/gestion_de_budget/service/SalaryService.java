package org.example.gestion_de_budget.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.example.gestion_de_budget.repository.SalaryRepository;
import org.example.gestion_de_budget.repository.UserRepository;
import org.example.gestion_de_budget.model.Salary;
import org.example.gestion_de_budget.model.User;

import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public class SalaryService {
    @Autowired
    private SalaryRepository salaryRepository;
    @Autowired
    private UserRepository userRepository;

    public Salary createSalary(Long userId,Salary salary) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
         salaryRepository.save(salary);
         salary.setUser(user);
        return salaryRepository.save(salary);
    }

    public void addSalaryToUser(Long userID, BigDecimal amount, String description) {
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Salary salary = new Salary();
        salary.setAmount(amount);
        salary.setDescription(description);
        salary.setUser(user);
        salary.setDate(LocalDate.now());
        salaryRepository.save(salary);
    }

    public BigDecimal calculateRemainingSalary(Long userId, BigDecimal expense) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        BigDecimal totalSalary = salaryRepository.findByUser(user).stream()
                .map(Salary::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal remainingSalary = totalSalary.subtract(expense);
        Salary salary = salaryRepository.findByUser(user).stream()
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Salary not found"));
        salary.setRemainingSalary(remainingSalary);
        salaryRepository.save(salary);
        System.out.println("Remaining salary: " + remainingSalary);
        return remainingSalary;
    }

}
