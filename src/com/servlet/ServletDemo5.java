package com.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Set;

/**
 * @Project：${project_name}
 * @File：${type_name}
 * @Author：何唯 （Erichhhhho）
 * @Date：17:09 2017/4/6
 * @Description：
 */
@WebServlet(name = "ServletDemo5",value = "/ServletDemo5",initParams ={ @WebInitParam(name = "data", value = "abcd"),@WebInitParam(
        name="data1",value="12334"
)})

public class ServletDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init(ServletConfig config) throws ServletException {

        super.init(config);
        Enumeration e=this.getServletConfig().getInitParameterNames();
        while(e.hasMoreElements())
        {
            String name= (String) e.nextElement();
            String value = this.getServletConfig().getInitParameter(name);
            System.out.println("name:"+name+"  Value:"+value+"\n"+"MajorVersion:"+this.getServletContext().getMajorVersion()+" MinorVersion"
            +this.getServletContext().getMinorVersion()+"Path:"+this.getServletContext().getRealPath("ServletDemo5")+"Sever:"+
            this.getServletContext().getServerInfo());

        }

    }

}
