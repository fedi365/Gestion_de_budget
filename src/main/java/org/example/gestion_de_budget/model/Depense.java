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
import jakarta.persistence.ManyToOne;
import lombok.ToString;

@Entity
@Table(name = "depenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Depense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double depense;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "MonthlyDepense_id")
    private MonthlyDepense monthlyDepense;
}
