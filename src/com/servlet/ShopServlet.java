package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @Project：${project_name}
 * @File：${type_name}
 * @Author：何唯 （Erichhhhho）
 * @Date：0:07 2017/4/15
 * @Description：
 */
@WebServlet(name = "ShopServlet",value = "/shop")
public class ShopServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession session = request.getSession();

        if(session.getAttribute("username")==null) {
            //未登录
            RequestDispatcher dispatcher=request.getRequestDispatcher("Login.html");
            dispatcher.forward(request,response);
        }else//已经登录
            response.sendRedirect("LoginSuccessServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
