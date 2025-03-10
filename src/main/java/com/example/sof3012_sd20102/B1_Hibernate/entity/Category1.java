package com.example.sof3012_sd20102.B1_Hibernate.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor // concturo full ts
@NoArgsConstructor // contructor khong ts
@Getter
@Setter
@Entity
// name: ten bang trong SQL
@Table(name = "category")
@ToString
public class Category1 {
    /**
     * J3: SQL Server -> Select * from
     * J4: HQL (Hibernate Query Language) : Truy van tren thuc the (class)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // cot tu tang
    private Long id;

    // Ten SQL trung ten java: Co the khong can phai ghi name
    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "category_name")
    private String categoryName;

}
