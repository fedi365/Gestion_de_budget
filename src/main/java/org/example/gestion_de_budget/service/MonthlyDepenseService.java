package org.example.gestion_de_budget.service;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

import org.example.gestion_de_budget.repository.MonthlyDepenseRepository;
import org.example.gestion_de_budget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.example.gestion_de_budget.model.User;
import org.example.gestion_de_budget.model.Depense;
import org.example.gestion_de_budget.model.MonthlyDepense;
import java.util.Map;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.example.gestion_de_budget.repository.DepenseRepository;
import java.util.ArrayList;
import java.util.Scanner;

@Service
public class MonthlyDepenseService {

    Scanner scanner = new Scanner(System.in);

    @Autowired
    private MonthlyDepenseRepository monthlyDepenseRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DepenseRepository depenseRepository;

    public MonthlyDepense createMonthlyDepense(MonthlyDepense monthlyDepense) {
        return monthlyDepenseRepository.save(monthlyDepense);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Depense createDepense(Depense depense) {
        return depenseRepository.save(depense);
    }

    public List<Depense> getAllDepenses() {
        return depenseRepository.findAll();
    }

    public Map<LocalDate, Double> sumDepensePerDay() {
        List<Depense> depenses = getAllDepenses();
        Map<LocalDate, Double> result = depenses.stream()
                .filter(depense -> depense.getDate() != null)
                .collect(
                        Collectors.groupingBy(
                                Depense::getDate,
                                Collectors.summingDouble(Depense::getDepense)));
        return result;

    }

    public Double sumDepensePerMonth(int monthParam) {
        return sumDepensePerDay().entrySet().stream()
                .filter(e -> e.getKey().getMonthValue() == monthParam)
                .mapToDouble(Map.Entry::getValue)
                .sum();
    }

    /**
     * public void MonthlyRest(Long userId) {
     * User user = userRepository.findById(userId)
     * .orElseThrow(() -> new RuntimeException("User not found"));
     * Map<Integer, Double> result = sumDepensePerMonth();
     * result.forEach((Key, value) -> {
     * 
     * Map<Integer, Double> RestofSalary = new HashMap<>();
     * RestofSalary.put(Key, user.getSalary() - (value));
     * System.out.println("la Rest of Salary est : " + RestofSalary);
     * });
     * 
     * }
     */

    public List<MonthlyDepense> getAllMonthlyDepenses() {
        return monthlyDepenseRepository.findAll();
    }

    public List<Depense> getMonthlyDepenses(int month) {
        List<Depense> monthlyDepenses = new ArrayList<>();
        for (Depense depense : depenseRepository.findAll()) {
            // Check if date is not null before accessing it
            if (depense.getDate() != null && depense.getDate().getMonth().getValue() == month) {
                monthlyDepenses.add(depense);
            }
        }
        return monthlyDepenses;
    }

    // @PostConstruct
    // public void init() {
    // int Month = scanner.nextInt();
    // System.out.println("===== DÉPENSES DU MOIS " + Month + " =====");

    // getMonthlyDepenses(Month).forEach(d -> System.out.printf(
    // "• %s | %.2f%n",
    // d.getDate(),
    // d.getDepense()));
    // }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Depense> depense() {
        return depenseRepository.findAll();
    }

}
