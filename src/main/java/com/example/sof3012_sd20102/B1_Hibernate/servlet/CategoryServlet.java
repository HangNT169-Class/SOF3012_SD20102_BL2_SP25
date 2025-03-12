package com.example.sof3012_sd20102.B1_Hibernate.servlet;

import com.example.sof3012_sd20102.B1_Hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// name: thich thi ghi khong thi thoi
// value: bat buoc => CHUA DUONG DAN CUA TRINH DUYET
// Duong dan:
// 1. Bat dau dau /
// 2. 1 project thi duong dan la duy nhat
@WebServlet(value = {
        "/category/hien-thi", // GET
        "/category/detail", // GET
        "/category/delete", // GET
        "/category/view-update", // GET
        "/category/update", // POST
        "/category/view-add", // GET
        "/category/add", // POST
        "/category/search" // GET
})
public class CategoryServlet extends HttpServlet {
    // Phuong thuc http (http methods): get, post, put, delete
    // J3 -> J5: chi lam viec voi 2 phuong thuc la get & post
    // Get: hien thi/lay ra ...
    // post: xu ly form ( neu co form : dang nhap, dang ky, add, update...)

    // Goi tang repository
    private CategoryRepository repository = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // viet 6 cai
        // B1: Lay ra uri cua duong dan
        String uri = request.getRequestURI(); //chinh la VD: /category/hien-thi
//        System.out.println(uri);
        if (uri.contains("hien-thi")) {
            // hien thi du lieu
            this.hienThiCategory(request, response);
        } else if (uri.contains("detail")) {
            // detail
            this.detailCate(request, response);
        } else if (uri.contains("delete")) {
            // delete
            this.deleteCate(request, response);
        } else if (uri.contains("view-update")) {
            // view - update
            this.viewUpdateCate(request, response);
        } else if (uri.contains("view-add")) {
            // view - add
            this.viewAddCate(request, response);
        } else {
            // search
            this.search(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // viet 2 cai
        String uri = request.getRequestURI();
        if (uri.contains("add")) {
            // add
            this.addCate(request, response);
        } else {
            // update
            this.updateCate(request, response);
        }
    }

    private void updateCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void addCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void deleteCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewUpdateCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detailCate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThiCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Day du lieu tu servlet -> sang view : request.setAttribute
//        int a = 5;
        request.setAttribute("listCate1",repository.getAll());
        // Chuyen trang di
        request.getRequestDispatcher("/buoi1/categorys.jsp").forward(request,response);
    }

}
