package com.yuantuo.dao.login;

/**
 * @Author: butcher
 * @Date: 2021/03/04/18:04
 * 查询员工信息，包括工号，密码，权限等
 */
public interface DaoEmployee {
    /**
     * 通过用户名查找密码与权限
     * @param id 工号
     * @return 密码与权限数组
     */
    String [] getPasswordJurisdiction(String id);
}
