package org.example.gestion_de_budget.service;

import java.math.BigDecimal;

import org.example.gestion_de_budget.model.Category;
import org.example.gestion_de_budget.repository.CategoryRepository;
import org.example.gestion_de_budget.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private UserRepository userRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category updateCategory(Long id, Category categoryDetails) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDetails.getName());
        category.setType(categoryDetails.getType());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    public void MonthlyLimit(Long userId, Category category) {
        BigDecimal total = transactionService.SumTransactions(userId);
        BigDecimal Limit = category.getMonthlyLimit();

        if (total.compareTo(Limit) > 0) {
            System.out.println("You have exceeded your monthly limit");

        }

    }

}
