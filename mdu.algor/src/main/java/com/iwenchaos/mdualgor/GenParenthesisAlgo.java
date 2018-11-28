package com.iwenchaos.mdualgor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chaos
 * on 2018/11/5. 14:35
 * 文件描述：
 */
public class GenParenthesisAlgo {


    public static void main(String[] args) {
        System.out.print(getMealTimeHour());

    }


    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();



        return results;
    }

    public static Long getTodayZeroPointTimestamps(){
        Long currentTimestamps=System.currentTimeMillis();
        Long oneDayTimestamps= Long.valueOf(60*60*24*1000);
        return currentTimestamps-(currentTimestamps+60*60*8*1000)%oneDayTimestamps;
    }


    public static int getMealTimeHour(){
        Date date = new Date("1542333600000");
        return date.getHours();
    }
}
