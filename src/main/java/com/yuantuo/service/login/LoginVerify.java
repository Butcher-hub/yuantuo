package com.yuantuo.service.login;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author: butcher
 * @Date: 2021/03/04/16:19
 *
 * 登录验证，连接数据库检查工号与密码是否正确
 */
@WebServlet("/page/login")
public class LoginVerify extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        工号
        String eId = request.getParameter("eId");
//        密码
        String ePassword = request.getParameter("ePassword");
//        是否添加cookie
        String eSave = request.getParameter("eSave");
//        验证码
        String eVerify = request.getParameter("eVerify");

//        查数据库

//        创建输出流
        PrintWriter out = response.getWriter();


    }
}
