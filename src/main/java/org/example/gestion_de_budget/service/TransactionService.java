package org.example.gestion_de_budget.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.example.gestion_de_budget.model.User;
import org.example.gestion_de_budget.repository.CategoryRepository;
import org.example.gestion_de_budget.repository.TransactionRepository;
import org.example.gestion_de_budget.repository.UserRepository;
import org.example.gestion_de_budget.model.Transaction;
import org.example.gestion_de_budget.model.TransactionType;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

 /**   public void AddTransaction(Long userId, BigDecimal amount, LocalDate date, String description,
            TransactionType type) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(date);
        transaction.setDescription(description);
        transaction.setType(type);
        transaction.setUser(user); // rattacher la transaction au user

        user.getTransactions().add(transaction); // AJOUTER, ne pas remplacer
        transactionRepository.save(transaction);

    }**/
    public void addTransactionMethode2(Transaction transaction,Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        transaction.setUser(user);
        transactionRepository.save(transaction);


    }

    public List<Transaction>getAllTransactions(Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return user.getTransactions();
    }

    public BigDecimal SumTransactions(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("this user Not Found"));
        BigDecimal Somme= user.getTransactions()
                .stream()
                .map(Transaction::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println("la Liste Of Transaction est : "+user.getTransactions());

        System.out.println("le Somme de Transaction pour cette User est : "+Somme);
        return Somme;
    }

}
