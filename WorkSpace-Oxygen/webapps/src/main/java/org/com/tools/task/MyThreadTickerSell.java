package org.com.tools.task;

public class MyThreadTickerSell {
    public static void main(String [] args){
    new TicketWindow().start(); //创建一个线程对象TicketWindow并开启
        new TicketWindow().start(); //创建一个线程对象TicketWindow并开启
        new TicketWindow().start(); //创建一个线程对象TicketWindow并开启
        new TicketWindow().start(); //创建一个线程对象TicketWindow并开启
    }
}


class TicketWindow extends Thread{
    private int ticket = 100;
    public void run() {
        while (true){

            if(ticket>0){
                Thread th = Thread.currentThread(); //获取当前线程
                String th_name = th.getName();//获取当前的线程的名字
                System.out.println(th_name+"正在发售第："+ticket--+"张票");
            }
        }
    }

}
