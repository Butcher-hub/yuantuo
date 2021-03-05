package com.yuantuo.dao.login.daoimp;

import com.yuantuo.dao.common.DButil;
import com.yuantuo.dao.login.DaoEmployee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Author: butcher
 * @Date: 2021/03/04/18:23
 *
 * 实现DaoEmployee接口，查询员工的信息
 */
public class DaoEmployeeImp implements DaoEmployee {
    /**
     * 通过工号获取密码与权限
     * @param id 工号
     * @return 密码与权限数组，下标0为密码，下标1为权限
     */
    @Override
    public String[] getPasswordJurisdiction(String id) {
        DButil dButil = new DButil();
        PreparedStatement ps = dButil.getPs("select ePassword,eJurisdiction from yt_employees where eId=?");
        try {
            ps.setString(1,id);
            ResultSet rs = dButil.getRs(ps.executeQuery());
//            结果只能有一个，所以用if就行
            if (rs.next()){
                String password = rs.getString("ePassword");
                String jurisdiction = rs.getString("eJurisdiction");
                String[] result = new String[2];
                result[0]=password;
                result[1]=jurisdiction;
                return result;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            dButil.closeAll();
        }
        return null;
    }

}
