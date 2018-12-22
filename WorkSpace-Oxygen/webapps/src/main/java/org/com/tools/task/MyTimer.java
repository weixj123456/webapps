package org.com.tools.task;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
 
public class MyTimer {
 
	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTimerTask myTimerTask = new MyTimerTask("Number 1.");
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sf.format(calendar.getTime()));
		calendar.add(Calendar.SECOND, 3);
//		myTimerTask.setName("scheduleAtFixedRate");
		MyTimerTask.setName("scheduleAtFixedRate");

		// timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 2000);
		
		timer.scheduleAtFixedRate(myTimerTask, 3000, 2000);
	}


}
