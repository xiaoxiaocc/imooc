package com.imooc.test;

import com.imooc.dao.ProduceDao;
import com.imooc.model.Goddess;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xuan on 2017/1/21.
 */
public class JDBCTestProduce {

    public static void main(String[] args)  {
        ProduceDao dao = new ProduceDao();

//      dao.select_nofilter();

        String sp_name = "";
        List<Goddess> result = null;
        Integer count = 0;
        try {
            //带入参的存储过程
//            result = select_filter(sp_name);
//            showResult(result);

            count = select_count();
            System.out.println(count);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public  static List<Goddess> select_filter(String sp_name) throws SQLException {
        ProduceDao dao = new ProduceDao();
        return dao.select_filter(sp_name);
    }

    public  static Integer select_count() throws SQLException {
        ProduceDao dao = new ProduceDao();
        return dao.select_count();
    }

    public static  void showResult(List<Goddess> result){
        for (int i = 0; i <result.size() ; i++) {
            System.out.println(result.get(i).getId()+":"+
                    result.get(i).getUser_name()+
                    result.get(i).getMobile());
        }
    }

}
