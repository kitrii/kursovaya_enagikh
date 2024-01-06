package javaserver.entities;



import jakarta.persistence.*;

import java.util.Set;

@Entity
public class BondEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bondId;
    @Column(nullable = false, unique = false)
    private String bondName;
    @Column(nullable = false, unique = false)
    private int repaymentPeriod;
    @Column(nullable = false, unique = false)
    private int couponRate;
    @Column(nullable = false, unique = false)
    private float yieldToMaturity;

    // Конструкторы, геттеры и сеттеры
}
