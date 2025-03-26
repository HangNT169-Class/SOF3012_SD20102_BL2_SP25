package com.example.sof3012_sd20102.B8_ScopeJSP;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DemoServlet", value = "/DemoServlet")
public class DemoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * J1: Pham vi truy cap - access modifier
         * public, protected, default, private
         * Scope trong JSP/Servlet
         *   1. Application
         *   2. Session
         *   3. Request
         *   4. Page => chi co file jsp
         *   VD: request.setAttribute
         *       session.setAttribute
         *   component 1 - file jsp1                component 2 - file jsp2
         *                           pham vi truy cap
         *   component 1 - file jsp3                component 2 - file jsp4
         *   Cu phap :
         *   Phia servlet
         *      <ten_scope>.setAttribute(ts1, ts2)
         *      VD: application.setAttribute()
         *   Phia JSP:
         *      tenLoaiScope.ts1
         *  1. request
         *  Chi ton tai gia tri khi servlet 1 -> jsp1.
         *  Neu jsp2 khong co gia tri truyen sang => khong goi duoc value cua request
         *  2. Page
         *  - Tuong tu vs request nhung chi ton tai o jsp servlet khong ton tai
         *  3. Session
         *  - Giong public
         *  - Moi jsp / servlet deu co the goi duoc
         *  - timeout: Thoi gian song. Default session 30 phut
         *  - Cau hinh thoi gian cua session trong web.xml
         *  4. application
         *  - Giong session nhung khong co thoi gian chet
         *  - Application chi chet khi he thong ngung chay
         */
        request.setAttribute("test1","Helloworld");
        // Cach goi application
        ServletContext application = getServletContext();
        application.setAttribute("applicationTest","Demo Aplication");

        // Goi session : HTTPSession
        HttpSession session = request.getSession();
        session.setAttribute("demo1","SD20102 - Java 4");
        request.getRequestDispatcher("/buoi8/demo.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
