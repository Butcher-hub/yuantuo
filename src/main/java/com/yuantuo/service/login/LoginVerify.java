package com.yuantuo.service.login;

import com.yuantuo.dao.common.DButil;
import com.yuantuo.dao.login.DaoEmployee;
import com.yuantuo.dao.login.daoimp.DaoEmployeeImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
        DaoEmployee daoEmployee = new DaoEmployeeImp();
        String[] pj = daoEmployee.getPasswordJurisdiction(eId);

//        判断员工是否存在
        if (pj!=null){
//            员工存在，判断密码是否正确
            if(ePassword.equals(pj[0])){
//                  密码正确
//                判断验证码是否正确
            }else {
//                密码错误
            }
        }else {
//            员工不存在
        }



//        创建输出流
        PrintWriter out = response.getWriter();


    }
}
