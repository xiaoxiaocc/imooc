package com.imooc.db;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;

/**
 * Created by xuan on 2017/1/12.
 */

/**
 * 本类用于获得数据库连接
 */
public class DBUtil {

    private static final String URL="jdbc:mysql://127.0.0.1:3306/imooc";
    private static final String NAME="root";
    private static final String PASSWORD="password";

    private static Connection conn = null;

    static {


        try {
            //加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
            //获取连接对象
           conn = DriverManager.getConnection(URL, NAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        }

    /**
     * 返回一个连接conn
     * @return
     */
    public static Connection getConnection(){
        return conn;
    }



}
