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
 * @Date：17:52 2017/5/15
 * @Description：
 */
@WebServlet(name = "LoginSuccessServlet",value = "/LoginSuccessServlet")
public class LoginSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);
        Cookie cookie=null;
        Cookie[] cookies=request.getCookies();

        for(int i=0 ;i<cookies.length&& cookies!=null;i++){
            if(cookies[i].getName().equals("logintimes")){
                cookie=cookies[i];
            }
        }


        String username = (String) session.getAttribute("username");
        out.write("当前用户名：" + username + "<br/>");
        Date date = (Date) session.getAttribute("loginTime");
        out.write("登入时间：" + date.toString() + "<br/>");
        out.write("欢迎第"+cookie.getValue()+"次访问本页面");
        out.write("<br><a href='LogoutServlet'>注销</a>&nbsp;");
        out.write("<a href='index.jsp'>返回</a>");
        out.write("<br>以下是商品描述：<br><br><br>");
        out.write(" <table width=\"470\" border=\"1\">\n" +
                "      <tr>\n" +
                "        <th>IDE</th>\n" +
                "        <th>Language</th>\n" +
                "        <th>Ranking</th>\n" +
                "      </tr>\n" +
                "\t<tr><td>Visual Studio</td>\n" +
                "    <td>C#</td>\n" +
                "    <td>1&nbsp;</td>\n" +
                "    \n" +
                "      </tr>\n" +
                "    <tr>\n" +
                "      <td>Eclipse</td>\n" +
                "      <td>Java</td>\n" +
                "      <td>2</td>\n" +
                "      </tr>\n" +
                "      <tr>\n" +
                "      <td>IntelliJ</td>\n" +
                "      <td>Java</td>\n" +
                "      <td>3</td></tr>\n" +
                "    </table>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request, response);
    }
}
