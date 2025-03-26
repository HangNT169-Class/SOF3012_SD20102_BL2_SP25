package com.example.sof3012_sd20102.B8_ScopeJSP;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "Demo1Servlet", value = "/Demo1Servlet")
public class Demo1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // B1: Goi session
        HttpSession session = request.getSession();
        // B2: Goi gia tri cua session
        String mess = (String) session.getAttribute("demo1");
        // B3: Co the su dung gia tri cua session bang nhieu cach...
        request.setAttribute("mess1", mess + "Convert to request");
        request.getRequestDispatcher("/buoi8/demo1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
