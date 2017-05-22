package com.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * @Project：${project_name}
 * @File：${type_name}
 * @Author：何唯 （Erichhhhho）
 * @Date：20:16 2017/5/15
* @Description：
 */
@WebServlet(name = "LoginServlet2")
public class LoginServlet2 extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(this.getInitParameter("url"),this.getInitParameter("username"),this.getInitParameter("password"));

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;

            sql = "SELECT * FROM user where Username='"+request.getParameter("name")+"'";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set

            while(rs.next()) {
                String pwd = rs.getString("password");
                if (pwd.equals(request.getParameter("password"))&& rs!=null) {
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginServlet");
                    dispatcher.forward(request, response);
                } else {
                    out.print("<script language='javascript'>alert('用户名与密码不匹配！')</script>");
                    out.print("<h1>下面在3s内重新返回登录页面</h1>");
                    out.print("<meta http-equiv='refresh' content='3;url="+request.getContextPath()+"Login2.html'>");

                }

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
