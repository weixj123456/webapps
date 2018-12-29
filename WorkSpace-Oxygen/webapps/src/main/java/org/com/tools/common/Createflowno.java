package org.com.tools.common;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

public class Createflowno {
	
	Logger	log	= Logger.getLogger(Createflowno.class);
	   
      public static String createnum() {
    	 Date date=new Date();  
 		 SimpleDateFormat formatter=new SimpleDateFormat("yyyyMMdd");  
 		 String time=formatter.format(date);  
 		 System.out.println(time);
 	     Date date1=new Date();  
 	     SimpleDateFormat formatter1=new SimpleDateFormat("HHmmss");  
 	     String time1=formatter1.format(date1);
 	     System.out.println(time1);
 	     String flowno=time+"0000"+time1;
 	     System.out.println(flowno);
 	     return flowno;
      }
}
