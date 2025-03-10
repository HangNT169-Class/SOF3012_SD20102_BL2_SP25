package com.example.sof3012_sd20102.B1_Hibernate.repository;

import com.example.sof3012_sd20102.B1_Hibernate.entity.Category1;
import com.example.sof3012_sd20102.B1_Hibernate.util.HibernateUtil1;
import org.hibernate.Session;

import java.util.List;

public class CategoryRepository {
    // CRUD : Them, Sua , Xoa, Search, Update, Phan trang...
    // Get all
    // J3: Connection: Mo cong ket noi
    // J4: Session: Mo 1 phien session
    private Session s;

    public CategoryRepository() {
        // khoi tao 1 phien session
        s = HibernateUtil1.getFACTORY().openSession();
    }

    // get.. all
    public List<Category1> getAll() {
        return s.createQuery("FROM Category1 ").list();
    }

    // get .. one
    public Category1 getOne(Long id1) {
        return s.find(Category1.class, id1);
    }
    // Them... Sua... Xoa

    public static void main(String[] args) {
//        System.out.println(new CategoryRepository().getAll());
        System.out.println(new CategoryRepository().getOne(1L));
    }
}
