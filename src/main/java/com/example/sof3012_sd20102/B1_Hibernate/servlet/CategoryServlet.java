package com.example.sof3012_sd20102.B1_Hibernate.servlet;

import com.example.sof3012_sd20102.B1_Hibernate.entity.Category1;
import com.example.sof3012_sd20102.B1_Hibernate.repository.CategoryRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

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

    @SneakyThrows
    private void addCate(HttpServletRequest request, HttpServletResponse response) {
        // Lay gia tri o input -> lay thong qua thuoc tinh name => getParameter
        // Bn o input => LAY 1 LAN DUY NHAT: BeanUtils
        Category1 cate = new Category1();
        BeanUtils.populate(cate,request.getParameterMap());
        repository.addCate(cate);
        response.sendRedirect("/category/hien-thi");
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAddCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi1/add-category.jsp").forward(request,response);
    }

    private void deleteCate(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // B1: Lay gia tri vua truyen tren duong dan => getParameter
        String id = request.getParameter("a1");
        // B3: Goi ham xoa
        Category1 cate = repository.getOne(Long.valueOf(id));
        repository.deleteCate(cate);
        // B4: Quay ve trang hien thi
        response.sendRedirect("/category/hien-thi");
    }

    private void viewUpdateCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri vua truyen tren duong dan => getParameter
        String id = request.getParameter("id");
        // B2: Khoi tao doi tuong cate
        Category1 cate = repository.getOne(Long.valueOf(id));
        // B3: Day doi tuong cate sang trang moi
        request.setAttribute("cate1",cate);
        // B4: Chuyen trang
        request.getRequestDispatcher("/buoi1/update-cate.jsp").forward(request,response);
    }

    private void detailCate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri vua truyen tren duong dan => getParameter
        String id = request.getParameter("a");
        // B2: Khoi tao doi tuong cate
        Category1 cate = repository.getOne(Long.valueOf(id));
        // B3: Day doi tuong cate sang trang moi
        request.setAttribute("cate1",cate);
        // B4: Chuyen trang
        request.getRequestDispatcher("/buoi1/detail-cate.jsp").forward(request,response);
    }

    private void hienThiCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Day du lieu tu servlet -> sang view : request.setAttribute
//        int a = 5;
        request.setAttribute("listCate1", repository.getAll());
        // Chuyen trang di
        request.getRequestDispatcher("/buoi1/categorys.jsp").forward(request, response);
    }

}
