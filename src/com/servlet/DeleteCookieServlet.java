package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Project：${project_name}
 * @File：${type_name}
 * @Author：何唯 （Erichhhhho）
 * @Date：14:24 2017/5/15
 * @Description：
 */
@WebServlet(name = "DeleteCookieServlet",value = "/DeleteCookieServlet")
public class DeleteCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();


        Cookie cookie=new Cookie( "logintimes","1" );
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath());

        response.addCookie(cookie);

        response.sendRedirect("/LoginServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                doPost(request, response);
    }
}
