package com.example.sof3012_sd20102.B1_Hibernate.repository;

import com.example.sof3012_sd20102.B1_Hibernate.entity.Category1;
import com.example.sof3012_sd20102.B1_Hibernate.util.HibernateUtil1;
import org.hibernate.Session;

import java.util.List;

public class ProductRepository {

    private Session s;

    public ProductRepository() {
        // khoi tao 1 phien session
        s = HibernateUtil1.getFACTORY().openSession();
    }

    public List<Category1> getAll() {
        return s.createQuery("FROM Product ").list();
    }

}
