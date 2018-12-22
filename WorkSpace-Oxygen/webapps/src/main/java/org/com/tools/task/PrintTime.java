package org.com.tools.task;

import java.text.*;
import java.util.*;
 
//class Example {
public class PrintTime {
    //public static void main(String args[]) {
	public static void printCurrentTime() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));//定义时区，可以避免虚拟机时间与系统时间不一致的问题
      //  System.out.println(new Date(System.currentTimeMillis()));//方法一：默认方式输出现在时间      
        Date nowTime = new Date();
//        System.out.println(nowTime);//方法二：Date方式，输出现在时间
        SimpleDateFormat matter = new SimpleDateFormat(
                "现在时间:yyyy年MM月dd日E HH时mm分ss秒");
        System.out.println(matter.format(nowTime));//方法三：SimpleDateFormat方式，完整输出现在时间  
    }
}