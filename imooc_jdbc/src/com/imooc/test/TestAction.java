package com.imooc.test;

import com.imooc.action.GoddessAction;
import com.imooc.model.Goddess;

import java.util.List;

/**
 * Created by xuan on 2017/1/20.
 */

/**
 * 本层是测试action层的
 */
public class TestAction {

    public static void main(String[] args) throws Exception {
        GoddessAction action = new GoddessAction();
        List<Goddess> result = action.query();
        for (int i = 0; i <result.size(); i++){
            System.out.println(result.get(i).getId() +
                    ":"+result.get(i).getUser_name());

        }


    }
}
