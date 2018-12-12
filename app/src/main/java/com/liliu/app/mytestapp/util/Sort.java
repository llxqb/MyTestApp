package com.liliu.app.mytestapp.util;


import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by li.liu on 2018/12/12.
 * 排序
 */

public class Sort {
    /**
     * 根据时间排序list
     */
    public static void ListSort(List<String> list) {
//        Collections.sort(list, (o1, o2) -> {
//            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            try {
//                Date dt1 = format.parse(o1.expectTime);
//                Date dt2 = format.parse(o2.expectTime);
//                if (dt1.getTime() > dt2.getTime()) {
//                    return 1;
//                } else if (dt1.getTime() < dt2.getTime()) {
//                    return -1;
//                } else {
//                    return 0;
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//            return 0;
//        });
    }
}
