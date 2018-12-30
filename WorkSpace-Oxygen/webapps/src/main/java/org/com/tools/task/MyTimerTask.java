package org.com.tools.task;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

import org.apache.log4j.Logger;
 
public class MyTimerTask extends TimerTask {
    
	Logger	log	= Logger.getLogger(MyTimerTask.class);
	
	private static String name;
 
	public MyTimerTask(String inputName) {
		name = inputName;
	}
 
	@Override
	public void run() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Current exec time is:" + sf.format(calendar.getTime()));
		System.out.println("Current exec name is:" + name);
	}
 
	public static String getName() {
		return name;
	}
 
	public static void setName(String name) {
		MyTimerTask.name = name;
	}
 
}

