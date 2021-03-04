package com.yuantuo.dao.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @Author: butcher
 * @Date: 2021/03/04/21:17
 *
 * 数据库连接工具类，可实现数据库一键连接，一键关闭流
 */
public class DButil {

    private String path = "";
    private String username ="";
    private String password = "";
    private String url = "";
    private Connection conn=null;
    private PreparedStatement ps=null;
    private ResultSet rs=null;

    /**
     * 构造方法，在new对象的时候读取配置文件中的数据库连接信息，创建连接
     */
    public DButil(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("dbConnectionConfig.properties"));
            this.path = properties.getProperty("path");
            this.username = properties.getProperty("username");
            this.password = properties.getProperty("password");
            this.url = properties.getProperty("url");
            Class.forName(path);
            this.conn = DriverManager.getConnection(url,username,password);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接之后的Connection
     * @return
     */
    public Connection getConn() {
        return conn;
    }

    /**
     * 创建预查询器对象
     * @param sql 要查询的SQL语句
     * @return 返回查询查询器对象，如果没有就返回null
     */
    public PreparedStatement getPs(String sql) {
        try {
            ps = conn.prepareStatement(sql);
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取结果集
     * @return 结果集 ResultSet
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * 设置结果集
     * @param rs ResultSet
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    /**
     * 关闭所有流
     */
    public void CloseAll(){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
