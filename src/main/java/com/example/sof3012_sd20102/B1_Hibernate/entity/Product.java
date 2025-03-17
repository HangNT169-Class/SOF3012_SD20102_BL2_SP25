package com.example.sof3012_sd20102.B1_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code")
    private String produtCode;

    @Column(name = "product_name")
    private String produtName;

    @Column(name = "price")
    private Float pice;

    @Column(name = "description")
    private String description;
    /**
     * 1. OneToOne: 2 bang qh 1-1
     * 2. OneToMany: 1->N:
     * 3. ManyToOne: N->1
     * 4. ManyToMany: N->N
     * 1 P -> 1 Ca
     * 1 Cate -> N P
     */
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category1 cate1;

}
