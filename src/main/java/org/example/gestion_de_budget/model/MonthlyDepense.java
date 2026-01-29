package org.example.gestion_de_budget.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "monthly_depenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MonthlyDepense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal depense;
    private LocalDate date;
    private String description;
    private BigDecimal remainingDepense;
    @OneToOne
    @JoinColumn(name = "Salary_id")
    private Salary salary;
}
