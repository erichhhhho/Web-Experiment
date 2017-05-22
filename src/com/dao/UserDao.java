package com.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Project：${project_name}
 * @File：${type_name}
 * @Author：何唯 （Erichhhhho）
 * @Date：21:36 2017/4/6
 * @Description：通过类装载器去读取资源文件
 */
public class UserDao {
    public void  update() throws IOException {
           /* InputStream in=UserDao.class.getClassLoader().getResourceAsStream("aa.properties");
            Properties prop = new Properties();
            prop.load(in);

            System.out.println(prop.getProperty("url"));*/

        //String path=UserDao.class.getClassLoader().getResource("aa.properties").getPath();
        //System.out.println(path);
        FileInputStream in = new FileInputStream("/F:/Desktop/JAVA project eric/TestServlet/out/artifacts/TestServlet_war_exploded/WEB-INF/classes/aa.properties");
        Properties dbconfig = new Properties();
        dbconfig.load(in);
        System.out.println(dbconfig.getProperty("url"));
    }

}
