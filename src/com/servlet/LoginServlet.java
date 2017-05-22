package com.servlet;

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
 * @Date：10:36 2017/4/13
 * @Description：
 */
@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");


        HttpSession session = request.getSession();
        session.setAttribute("username",request.getParameter("name"));
        Date sessionCreated = new Date();
        session.setAttribute("loginTime",sessionCreated);

        PrintWriter out = response.getWriter();

        Cookie cookie=null;
        Cookie cookie1=null;
        //获取请求相关的Cookie
        Cookie[] cookies=request.getCookies();

            for(int i=0 ;i<cookies.length&& cookies!=null;i++){

                if(cookies[i].getName().equals("loginname")){
                    cookies[i].setValue(request.getParameter("name"));
                    response.addCookie(cookies[i]);
                    cookie1=cookies[i];
                }
                if(cookies[i].getName().equals("logintimes")){
                    int value=Integer.parseInt(cookies[i].getValue())+1;
                    cookies[i].setValue(Integer.toString(value));
                    response.addCookie(cookies[i]);
                    cookie=cookies[i];
                }

            }
        if(cookie==null)
        {
            int maxAge=-1;
            cookie=new Cookie("logintimes","1" );
            cookie1=new Cookie("loginname", request.getParameter("name"));
            cookie.setPath(request.getContextPath());
            cookie.setMaxAge(maxAge);
            response.addCookie(cookie);
            cookie1.setPath(request.getContextPath());
            cookie1.setMaxAge(maxAge);//设置cookie的生命周期
            response.addCookie(cookie1);

        }

        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
                out.println("<HTML>");
        out.println("  <HEAD><TITLE>恭喜你登陆成功</TITLE></HEAD>");
        out.println("  <BODY>");
        //三秒跳转到/shop
        if(cookie1.getValue()!=null)
         out.print("<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/shop'>");
        else
            out.print("<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"/Login.html'>");
        out.println("欢迎第"+cookie.getValue()+"次访问本页面");
        out.print(session.getAttribute("loginTime")+"当前用户："+cookie1.getValue());
        out.print("<br><a href='/DeleteCookieServlet'>清除访问记录</a>");

        out.println("  </BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();


        //  response.sendRedirect("/shop");
       // request.getRequestDispatcher("/shop").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }
}
