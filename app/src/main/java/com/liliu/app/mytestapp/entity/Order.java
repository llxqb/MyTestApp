package com.liliu.app.mytestapp.entity;

import java.util.List;

/**
 * Created by li.liu on 2018/12/4.
 */

public class Order {
//    public static int BEAN_TOP = 0;
//    public static int BEAN_BOTTOM = 1;
//
//    public int month;
//    public List<OrderInfo> mOrderInfos;
//    public int showType;//显示不同类型布局
//
//    public static class OrderInfo {
//        public int month;//所属月份
//        public String date;
//        public int num;
//    }

    public int month;//所属月份
//    public String date;//日期
    public int numTotal;//订单总数量
    public List<OrderInfo> mOrderInfos;
//
    public static class OrderInfo {
        public String date;//日期
        public int num;//订单数量
    }

}
