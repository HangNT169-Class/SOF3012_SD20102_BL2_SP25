package com.example.sof3012_sd20102.B9_Filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "AuthFilter", value = {
//        // Liet ke cac duong dan chung ta can check authen
        "/category/*"
})
public class AuthFilter implements Filter {
    /**
     * filter: Bo loc => Khi chay trang web thi phai vao fiter truoc de check quyen
     * Authen: Check tk ton tai trong he thong hay khong
     * Author: Phan quyen nguoi dung
     */
    public void init(FilterConfig config) throws ServletException {
        //Noi chay dau tien cua filter
    }

    public void destroy() {
        // Noi chay khi xong lop filter
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        // Noi ma xu ly xem duong dan hop le hay khong
        // B1: Convert request, response
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        // B2: Goi session
        HttpSession session = req.getSession();
        // Check ton tai session hay khong
        if (session.getAttribute("u1") != null) {
            // Check tiep
            String username = (String) session.getAttribute("u1");
            if(username.equalsIgnoreCase("HangNT169")
                    || username.equalsIgnoreCase("NguyenVV4")
            ){
                // dang nhap thanh cong
                chain.doFilter(request,response);
            }else{
                // Tai khoan khong hop le
                res.sendRedirect("/login");
            }
        } else {
            // Khong co session
            res.sendRedirect("/login");
        }
    }
}
