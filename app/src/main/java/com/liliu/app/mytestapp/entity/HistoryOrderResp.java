package com.liliu.app.mytestapp.entity;


/**
 * Created by li.liu on 2018/12/3.
 * 历史订单返回
 */

public class HistoryOrderResp {
    //月份
    public String month;
    //单月订单数量
    public String monthOrderNum;


    //日期
    public String day;
    //单日订单数量
    public String dayOrderNum;
    //单日订单取消数量
    public String cancelOrderNum;

    //是否显示
    public boolean isShow;
    //是否有请求过
    public boolean isLoadOne;


}
