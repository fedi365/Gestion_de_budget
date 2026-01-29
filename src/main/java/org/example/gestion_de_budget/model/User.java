package org.example.gestion_de_budget.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String password;
    private String email;
    private LocalDate createdAt;
    private Double salary;
    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions = new ArrayList<>();

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDate.now();
    }

}
