package com.Bean;

import java.util.Date;

/**
 * @Project：${project_name}
 * @File：${type_name}
 * @Author：何唯 （Erichhhhho）
 * @Date：22:10 2017/5/17
 * @Description：
 */
public class msgaddjvb {


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;
    private String username;

    private Date logintime;

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Date getLogintime() {
        return logintime;
    }







    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }





}
