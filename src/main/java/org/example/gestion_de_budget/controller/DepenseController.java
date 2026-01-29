package org.example.gestion_de_budget.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.gestion_de_budget.model.Depense;
import org.example.gestion_de_budget.model.User;
import org.example.gestion_de_budget.service.MonthlyDepenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDate;
import java.util.Map;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/depenses")
@CrossOrigin(origins = "http://localhost:5173")
public class DepenseController {
    @Autowired
    private MonthlyDepenseService monthlyDepenseService;

    @PostMapping("/create")
    public Depense createDepense(@RequestBody Depense depense) {
        return monthlyDepenseService.createDepense(depense);
    }

    @PostMapping("/CreateUser")
    public User createUser(@RequestBody User user) {
        return monthlyDepenseService.createUser(user);
    }

    @GetMapping("/DepensesPerDay")
    public Map<LocalDate, Double> getDepensesPerDay() {
        return monthlyDepenseService.sumDepensePerDay();
    }

    @GetMapping("/DepensesPerMonth/{month}")
    public Double getDepensesPerMonth(@PathVariable int month) {
        return monthlyDepenseService.sumDepensePerMonth(month);
    }

    @GetMapping("/alldepenses")
    public List<Depense> getAllDepenses() {
        return monthlyDepenseService.getAllDepenses();
    }

    @GetMapping("/MonthlyDepenses/{month}")
    public List<Depense> getMonthlyDepenses(@PathVariable int month) {
        return monthlyDepenseService.getMonthlyDepenses(month);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {
        return monthlyDepenseService.getAllUsers();
    }

    @GetMapping("/depenses")
    public List<Depense> getDepenses() {
        return monthlyDepenseService.depense();
    }

}
