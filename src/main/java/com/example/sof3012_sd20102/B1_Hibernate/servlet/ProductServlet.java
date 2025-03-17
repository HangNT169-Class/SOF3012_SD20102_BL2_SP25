package com.example.sof3012_sd20102.B1_Hibernate.servlet;

import com.example.sof3012_sd20102.B1_Hibernate.repository.CategoryRepository;
import com.example.sof3012_sd20102.B1_Hibernate.repository.ProductRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductRepository repository = new ProductRepository();

    private CategoryRepository cateRepo = new CategoryRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("ProductServlet")) {
            // hien thi
            request.setAttribute("lists", repository.getAll());
            request.setAttribute("listCate", cateRepo.getAll());
            request.getRequestDispatcher("/buoi1/product.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
