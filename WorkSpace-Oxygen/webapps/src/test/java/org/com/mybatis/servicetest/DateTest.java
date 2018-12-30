package org.com.mybatis.servicetest;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	
	
	 public static void main(String args[]) {
	       // 初始化 Date 对象
//	       Date date = new Date("yyyy-MM-dd hh:mm:ss");
	        
	       // 使用 toString() 函数显示日期时间
//	       System.out.println(date.toString());
	       
	       Date dNow = new Date( );
	       SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
	  
	       System.out.println("当前时间为: " + ft.format(dNow));
	       
	        SimpleDateFormat aDate=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	        SimpleDateFormat bDate=new SimpleDateFormat("yyyy-mmmmmm-dddddd");
	        long now=System.currentTimeMillis();
	        System.out.println("aDate:"+aDate.format(now));
	        System.out.println("bDate:"+bDate.format(now));
	   }
}
