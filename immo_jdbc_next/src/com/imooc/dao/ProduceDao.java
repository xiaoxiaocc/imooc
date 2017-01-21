package com.imooc.dao;

import com.imooc.db.DBUtil;
import com.imooc.model.Goddess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuan on 2017/1/21.
 */

/**
 * 存储过程store procedure
 */
public class ProduceDao {

    public  static Integer select_count() throws SQLException {
        Integer count = 0;

        Connection conn = DBUtil.getConnection();
        CallableStatement cs = conn.prepareCall("call sp_select_count(?)");
        //注册一下出参
        //type 为java封装的sql的类型
        cs.registerOutParameter(1, Types.INTEGER);
        cs.execute();
        //处理返回的结果：结果集，出参
        count = cs.getInt(1);
        return count;
    }

    public static List<Goddess> select_filter(String sp_name) throws SQLException {

        List<Goddess> result = new ArrayList<Goddess>();

        Connection conn = DBUtil.getConnection();
        CallableStatement cs = conn.prepareCall("call sp_select_filter(?)");
        cs.setString(1,sp_name);
        cs.execute();

        ResultSet rs = cs.getResultSet();

        Goddess g = null;
        while(rs.next()){
            g = new Goddess();
            g.setId(rs.getInt("id"));
            g.setUser_name(rs.getString("user_name"));
            g.setAge(rs.getInt("age"));
            g.setMobile(rs.getString("mobile"));
            result.add(g);
        }

        return result;
    }

    public static void select_nofilter() throws SQLException {

        //获得连接
        Connection conn = DBUtil.getConnection();
        //获取的CallableStatement
        CallableStatement cs = conn.prepareCall("call sp_select_nofilter");
        //执行存储过程
        cs.execute();
        //处理返回结果：结果集，出参
        ResultSet rs = cs.getResultSet();

        while(rs.next()){
            System.out.println(rs.getString("user_name")+rs.getString("email")+
            rs.getString("mobile"));

        }



    }



}
