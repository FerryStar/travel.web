package com.lzx.travel.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet{

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("userServlet的add方法...");
    }

    public void find(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("userServlet的find方法...");
    }
}
