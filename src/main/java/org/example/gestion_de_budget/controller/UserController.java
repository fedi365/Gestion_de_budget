package org.example.gestion_de_budget.controller;

import org.example.gestion_de_budget.model.Salary;
import org.example.gestion_de_budget.model.Transaction;
import org.example.gestion_de_budget.model.User;
import org.example.gestion_de_budget.service.SalaryService;
import org.example.gestion_de_budget.service.TransactionService;
import org.example.gestion_de_budget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private TransactionService transactionService;
    @Autowired
    private SalaryService salaryService;

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.getALLusers();
    }

    @PostMapping("/createUser")
    public User createuser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @PostMapping("/users/{userId}/transactions")
    public void addTransactionToUser(@PathVariable Long userId, @RequestBody Transaction transaction) {
        transactionService.addTransactionMethode2(transaction, userId);
    }

    @PostMapping("/users/{userId}/salaries")
    public Salary addSalaryToUser(@PathVariable Long userId, @RequestBody Salary salary) {
        salaryService.createSalary(userId, salary);
        return salary;
    }

    @GetMapping("/users/{userId}/transactions")
    public List<Transaction> getListeTransactionByUser(Long userId) {
        return transactionService.getAllTransactions(userId);
    }

    @GetMapping("/users/{userId}/SumTransactions")
    public BigDecimal getSumTransactionsByUser(Long userId) {
        return transactionService.SumTransactions(userId);
    }

}
