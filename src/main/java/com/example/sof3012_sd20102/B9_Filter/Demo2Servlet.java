package com.example.sof3012_sd20102.B9_Filter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Demo2Servlet", value = {
        "/login",
})
public class Demo2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/buoi9/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Lay gia tri tu input
        String username = request.getParameter("uname");
        String password = request.getParameter("p1");
        HttpSession session = request.getSession();
        session.setAttribute("u1", username);
        // B2: Check tai khoan
        if ((username.equalsIgnoreCase("hangnt169") && password.equals("123456"))
                || (username.equalsIgnoreCase("nguyenvv4") && password.equals("1234567"))
        ) {
            response.sendRedirect("/category/hien-thi");

        } else {
            request.setAttribute("error", "tai khoan khong hop le");
            request.getRequestDispatcher("/buoi9/login.jsp").forward(request, response);
        }
    }
}
