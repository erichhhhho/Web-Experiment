<%@ page import="java.lang.*" %>
<%@page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="javax.swing.plaf.nimbus.State" %><%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2017/5/17
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>

    <title>处理message</title>
</head>
<body>
        <jsp:useBean id="Msgaddjvb" class="com.Bean.msgaddjvb" scope="session" />
        <jsp:setProperty name="Msgaddjvb" property="logintime"
                         value='<%=(Date) new Date()%>' />
        <jsp:setProperty name="Msgaddjvb" property="username"
                         value='<%=(String) session.getAttribute("username")%>' />
        <jsp:setProperty name="Msgaddjvb" property="message" param="message" />

       <%!
           Connection conn = null;
           PreparedStatement stmt=null;

       %>

        <%

           try{
               //STEP 2: Register JDBC driver
               Class.forName("com.mysql.jdbc.Driver");

               //STEP 3: Open a connection
               System.out.println("Connecting to database...");
               conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?characterEncoding=utf-8","root","root");

               //STEP 4: Execute a query
               System.out.println("Creating statement...");
               stmt = conn.prepareStatement("INSERT INTO message VALUES (?,?,?)");
               String username=Msgaddjvb.getUsername();
               String localtime=Msgaddjvb.getLogintime().toString();

               String message = new String(Msgaddjvb.getMessage().getBytes("ISO-8859-1"),"utf-8");
               stmt.setString(1,username);
              stmt.setString(2,localtime);
              stmt.setString(3,message);
               stmt.executeUpdate();

               //STEP 5: Extract data from result set


               //STEP 6: Clean-up environment

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
       %>

        <p>

        <h1>以下信息已存进数据库：</h1>
            登录名：
        <br>
        <%=Msgaddjvb.getUsername()%>
        <br>
        登陆时间：

        <%=Msgaddjvb.getLogintime()%>

        <br>
        留言信息：
        <%=new String(Msgaddjvb.getMessage().getBytes("ISO-8859-1"),"utf-8")%>
        <br>
        <a href="index.jsp">返回首页</a>
        </p>


</body>
</html>
