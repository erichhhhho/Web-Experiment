<%@ page import="java.sql.*" %><%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2017/5/19
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>msgshow.jsp</title>
</head>
<body>
<jsp:useBean id="Msgaddjvb" class="com.Bean.msgaddjvb" scope="session" />
<%!
    Connection conn = null;
    Statement stmt=null;
    ResultSet rs = null;
    int i;
%>

<%

    try{
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");

        //STEP 4: Execute a query
        System.out.println("Creating statement...");
        stmt =conn.createStatement();

        String sql="select username,logintime,message from message";

       rs=stmt.executeQuery(sql);
       i=1;
        %>
<table border="1">
    <caption>留言板</caption>
    <tr>
        <th>留言记录</th>
        <th>用户名</th>
        <th>登录时间</th>
        <th>留言内容</th>
    </tr>
    <%
        //STEP 5: Extract data from result set
        while(rs.next()) {

            String username = rs.getString("username");
            String logintime = rs.getString("logintime");
            String message = rs.getString("message");
        %>
    <tr>
        <td valign="center"><%=i%></td>
        <td valign="center"><%=username%></td>
        <td valign="center"><%=logintime%></td>
        <td valign="center"><%=message%></td>
    </tr>
    <%

                i++;
        }
%>


</table>
        <%
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
</body>
</html>
