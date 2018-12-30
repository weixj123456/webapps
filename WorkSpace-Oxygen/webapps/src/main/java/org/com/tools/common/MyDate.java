package org.com.tools.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.time.DateFormatUtils;

public class MyDate {

//	public void f1() {
//		  //将long字符串转换成格式时间输出 		  
//		   String time="1256006105375";  	  
//		    Date date=new Date(Long.parseLong(time));  
//		    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
//		    time=formatter.format(date);  
//		    System.out.println(time);  
//	  }
	
	/**
	 * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
	 */
	private static String formatDate(Date date, Object... pattern) {
		String formatDate = null;
		if (pattern != null && pattern.length > 0) {
			formatDate = DateFormatUtils.format(date, pattern[0].toString());
		} else {
			formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
		}
		return formatDate;
	}
	
	public static String getNowDate(){   
	    String temp_str="";   
	    Date dt = new Date();   
	    //最后的aa表示“上午”或“下午”    HH表示24小时制    如果换成hh表示12小时制   
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");   
	    temp_str=sdf.format(dt);   
	    return temp_str;   
	}
	
	public static String DateToStr(Date date) {
		  
		   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		   String str = format.format(date);
		   return str;
		} 
	
	public static Date turnStrToDate(String time) throws ParseException {
		  //字符串转换成时间
		    //time="2010-11-20 11:10:10";  	  
		    Date date=null;  
		    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    date=formatter.parse(time);
		    //System.out.println(date);
		    return date;
	  }
	
	public static String getCurrentDate(){
		  //取得当前系统时间，返回yyyy-MM-dd HH:mm:ss字符串
		    Date date=new Date();
		    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String time=formatter.format(date);
		    //System.out.println(time);
		    return time;
	  }
	
	public String getCurrentTime(){
		  //取得当前系统时间，返回 HH:mm:ss字符串
		    Date date=new Date();
		    SimpleDateFormat formatter=new SimpleDateFormat("HH:mm:ss");
		    String time=formatter.format(date);
		    //System.out.println(time);
		    return time;
	  }
	
	public static String stringToDatestr(String time) throws ParseException{
		    //将20101125102503转换成2010-11-25 10:25:03输出
		   //  time="20101125102503";
		    SimpleDateFormat formatter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    SimpleDateFormat formatter2=new SimpleDateFormat("yyyyMMddHHmmss");
		    time=formatter1.format(formatter2.parse(time));
		    //System.out.println(time);
		    return time;
	  }

	public static String getToday() {
		// TODO Auto-generated method stub
		Date date=new Date();
	    SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time=formatter.format(date);
	    //System.out.println(time);
	    return time;
	}
	
	// 获取当前时间戳1
	public static String getTimeStr() {
		long currentTime=new Date().getTime();
		String str=currentTime+"";
		return str;
	}
	
	public static String getTimeString() {
//		Date d = new Date();
//		SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//12小时制  
//		System.out.println(ss.format(d));
		Date date = new Date();
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//24小时制  
		String LgTime = sdformat.format(date);
		System.out.println(LgTime);
		return LgTime;
		
	}
	
	// 获取当前时间戳2
	public static String getCurrentTimeMillis() {
		long l=System.currentTimeMillis();
		String str=l+"";
		return str;		
	}
	
	/**
	 * 得到当前日期和时间字符串 格式（yyyy-MM-dd HH:mm:ss）
	 */
	public static String getDateTimer() {
		return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
	}
	
	/**
	 * 得到当前日期和时间字符串 格式（yyyyMMddHHmmss）
	 */
	public static String getDateTimestr() {
		return formatDate(new Date(), "yyyyMMddHHmmss");
	}
	
//	public static void main(String[] args) throws ParseException {
////		   System.out.println(getCurrentDate());
////		  System.out.println(MyDate.stringToDatestr(" "));
//		  System.out.println(MyDate.getNowDate());
//		  System.currentTimeMillis();     //1532868979731  获取当前时间戳
//		  System.out.println(System.currentTimeMillis());
//		  System.out.println(MyDate.getDateTimestr());
//
//	}

}
