package com.example.sof3012_sd20102.B1_Hibernate.repository;

import com.example.sof3012_sd20102.B1_Hibernate.entity.Category1;
import com.example.sof3012_sd20102.B1_Hibernate.util.HibernateUtil1;
import jakarta.persistence.Query;
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
    // them
    public void addCate(Category1 cate) {
        try {
            // bat dau 1 tran moi
            s.getTransaction().begin();
            // add : save / persist / saveOrUpdate
            s.persist(cate); // the,
            // commit
            s.getTransaction().commit();
        } catch (Exception e) {
            // roll back lai du lieu ban dau
            s.getTransaction().rollback();
        }
    }

    // update
    public void updateCate(Category1 cate) {
        try {
            // bat dau 1 tran moi
            s.getTransaction().begin();
            // update : merge/ saveOrUpdate
            s.merge(cate); // the,
            // commit
            s.getTransaction().commit();
        } catch (Exception e) {
            // roll back lai du lieu ban dau
            s.getTransaction().rollback();
        }
    }

    // delete
    public void deleteCate(Category1 cate) {
        try {
            // bat dau 1 tran moi
            s.getTransaction().begin();
            // delete
            s.delete(cate); // the,
            // commit
            s.getTransaction().commit();
        } catch (Exception e) {
            // roll back lai du lieu ban dau
            s.getTransaction().rollback();
        }
    }

    /**
     * Tim kiem theo ten trong ds cate
     */
    // String categoryCode
    public List<Category1> searchByName(String name) {
        // B1: Viet HQL
        String hql = "SELECT c FROM Category1 c WHERE c.categoryName = :a";
        // B2: Tao cau Query
        Query q = s.createQuery(hql);
        // B3: Set gia tri cho dau ?
        q.setParameter("a", name);
//        q.setParameter(2, categoryCode);
        // B4: Tra ve du lieu
        return q.getResultList(); // tra ve 1 danh sach
        // tra ve 1 doi tuong => getSingleResult
    }

    // getOne => search
    public Category1 getOneC2(Long id) {
        String hql = "SELECT c FROM Category1 c WHERE c.id = ?1";
        Query q = s.createQuery(hql);
        q.setParameter(1, id);
        return (Category1) q.getSingleResult();
    }

    public List<Category1> sapXep() {
        String hql = "select c from Category1 c order by c.categoryName";
        Query q = s.createQuery(hql);
        return q.getResultList();
    }

    public List<Category1> timTheoKhoang(Long idMin,Long idMax){
        String hql="SELECT c FROM Category1 c WHERE c.id>=?1 AND c.id <=?2 ORDER BY c.categoryName ,c.id DESC";
        Query q = s.createQuery(hql);
        q.setParameter(1,idMin);
        q.setParameter(2,idMax);
        return q.getResultList();
    }

    public static void main(String[] args) {
        //System.out.println(new CategoryRepository().searchByName("Cate1"));
        System.out.println(new CategoryRepository().timTheoKhoang(2L,10L));
    }
}
