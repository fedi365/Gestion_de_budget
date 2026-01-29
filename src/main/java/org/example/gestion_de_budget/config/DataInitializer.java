package org.example.gestion_de_budget.config;

import org.example.gestion_de_budget.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import org.example.gestion_de_budget.model.User;
import org.example.gestion_de_budget.model.TransactionType;
import org.example.gestion_de_budget.repository.UserRepository;
import org.example.gestion_de_budget.repository.SalaryRepository;
import org.example.gestion_de_budget.service.SalaryService;
import org.example.gestion_de_budget.service.TransactionService;
import java.math.BigDecimal;
import java.time.LocalDate;
/**
 * @Component
 *            public class DataInitializer implements CommandLineRunner {
 * 
 * @Autowired
 *            private TransactionService transactionService;
 * 
 * @Autowired
 *            private UserRepository userRepository;
 * 
 * @Autowired
 *            private SalaryService salaryService;
 * 
 * @Autowired
 *            private CategoryService categoryService;
 * 
 * @Override
 * @Transactional
 *                public void run(String... args) {
 *                User user = new User();
 *                user.setFullName("Test User");
 *                user.setEmail("test@test.com");
 *                user.setCreatedAt(LocalDate.now());
 *                userRepository.save(user);
 * 
 *                transactionService.AddTransaction(
 *                user.getId(),
 *                new BigDecimal("100"),
 *                LocalDate.now(),
 *                "Test",
 *                TransactionType.EXPENSE);
 *                transactionService.AddTransaction(
 *                user.getId(),
 *                new BigDecimal("200"),
 *                LocalDate.now(),
 *                "Test",
 *                TransactionType.EXPENSE);
 *                transactionService.AddTransaction(
 *                user.getId(),
 *                new BigDecimal("650"),
 *                LocalDate.now(),
 *                "Test",
 *                TransactionType.EXPENSE);
 * 
 * 
 *                transactionService.SumTransactions(user.getId());
 * 
 *                salaryService.addSalaryToUser(1L, new BigDecimal("8000"),
 *                "Salary for month of January");
 *                salaryService.calculateRemainingSalary(1L, new
 *                BigDecimal("100"));
 * 
 *                Category category = new Category();
 *                category.setMonthlyLimit(new BigDecimal("100"));
 *                category.setName("Food");
 *                category.setType(TransactionType.EXPENSE);
 *                category = categoryService.createCategory(category);
 * 
 * 
 *                categoryService.MonthlyLimit(1L, category);
 *                System.out.println("Liste des transactions : " +
 *                user.getTransactions().stream()
 *                .map(t -> t.getAmount() + " le " + t.getDate())
 *                .toList());
 *                }
 * 
 *                }
 **/
