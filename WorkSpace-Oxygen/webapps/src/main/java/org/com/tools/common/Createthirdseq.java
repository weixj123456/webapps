package org.com.tools.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Createthirdseq {
	Logger	log	= Logger.getLogger(Createthirdseq.class);
	  static String thirdseq=null;
      public static String createnum(int num){
    	  //int num=0;
    	  if(num<0) {
    		 System.out.println("请重新输入大于零的数字");
    	  }else {
    	  Date date=new Date();  
  		 SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd");  
  		 String time=formatter.format(date);  
  		// System.out.println(time);
  	     num++;
  	     @SuppressWarnings("unused")
		Numutil num1=new Numutil(""+num,3);
  	     String str=Numutil.autoGenericCode();
  	     String thirdseq="PPD"+time+str;
  	     System.out.println(thirdseq);
  	     }
  	     return thirdseq;     
      }
      public static void main(String[] args) {
		new Createthirdseq();
		String thirdseq=Createthirdseq.createnum(5);
		System.out.println(thirdseq);
	}
}
