package org.example.gestion_de_budget.service;

import java.math.BigDecimal;

import org.example.gestion_de_budget.model.CATEGORY;
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

    public CATEGORY createCategory(CATEGORY category) {
        return categoryRepository.save(category);
    }

    public List<CATEGORY> getAllCategories() {
        return categoryRepository.findAll();
    }


    public CATEGORY updateCategory(Long id, CATEGORY categoryDetails) {
        CATEGORY category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        category.setName(categoryDetails.getName());
        category.setType(categoryDetails.getType());
        return categoryRepository.save(category);
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }


    public void MonthlyLimit(Long userId, CATEGORY category) {
        BigDecimal total = transactionService.SumTransactions(userId);
        BigDecimal Limit =category.getMonthlyLimit();

        if (total.compareTo(Limit) > 0){
            System.out.println("You have exceeded your monthly limit");

        }

    }

}
