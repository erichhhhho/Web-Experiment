<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: q
  Date: 2017/5/17
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>留言页面</title>
    <link rel="stylesheet" type="text/css" href="css/2.css">
</head>
<body onload="checklogin()">
<% request.setCharacterEncoding("UTF-8");%>
<script language="JavaScript">
    function checklogin() {
        var abc;
        var username = "<%=session.getAttribute("username")%>"
        var logintime= "<%=session.getAttribute("loginTime")%>"

        if (username == "" || username == null||username=="null") {
            alert("当前登录用户为空，请重新登录");
            window.location.href="Login.html";
        }
        if (logintime == "" || logintime == null||logintime=="null") {
            alert("当前登录用户为空，请重新登录");
            window.location.href="Login.html";
        }
    }

    function show() {
        var str=document.getElementById("message").value;
        alert("你所输入的留言是："+str)
    }
</script>
<form action="message.jsp" method="post" class="STYLE-NAME" onsubmit="show()">
    <h1>Message
        <span>Please leave your message in this form.</span>
    </h1>
    <label>
        <span>Your Name :</span>
        <input id="name" type="text" name="name" placeholder="<%=session.getAttribute("username")%>" disabled="disabled"/>
    </label>
    <label>
        <span>Comment Time :</span>
        <input id="logintime" type="text" name="logintime" placeholder="<%=new Date()%>" disabled="disabled"/>
    </label>
    <label>
        <span>Message :</span>
        <textarea id="message" name="message" placeholder="Your Message to Us"></textarea>
    </label>

    <label>
        <span>&nbsp;</span>
        <input type="submit" class="button" name="submit"  value="Send" />
        <span>&nbsp;</span>
        <input type="button" class="button" name="return"  value="Return"  onclick="location='index.jsp'"/>
    </label>

</form>
</body>
</html>
