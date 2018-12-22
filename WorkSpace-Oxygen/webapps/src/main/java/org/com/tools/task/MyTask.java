package org.com.tools.task;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;



public class MyTask {
	//public static void main(String[] args) { 
	public static void runMytask() {
        Runnable runnable = new Runnable() { 
        	@SuppressWarnings("unused")
			int i=0;
            public void run() {  
                // task to run goes here
            	i++;
//                System.out.println("Hello !!"+i);
//                System.out.println("输出当前时间0");
//                PrintTime.printCurrentTime();
//                System.out.println("输出当前时间1");
            	try {
			//		Docupdate0.thread();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        };
        ScheduledExecutorService service = Executors  
                .newSingleThreadScheduledExecutor();  
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间  
        //service.scheduleAtFixedRate(runnable, 3, 1000, TimeUnit.SECONDS); 
        //100毫秒执行一次
        service.scheduleAtFixedRate(runnable, 5000, 10, TimeUnit.MILLISECONDS);
        //System.out.println("输出当前时间1");
        PrintTime.printCurrentTime();
    }  
	
	public static void main(String[] args) {
		MyTask.runMytask();
	}
}
