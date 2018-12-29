package org.com.tools.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.Test;
 
public class ThreadDemo {
    // 使用线程池,长度为2
    private final static ExecutorService pool = Executors.newFixedThreadPool(2);
    final long waitTime = 1 * 1000;
    final static long awaitTime = 1 * 1000;
 
    // 对于100个数,开启你两个线程遍历
 
    // 定义一个内部线程类
    class CountThread implements Runnable {
        private long a;
 
        public CountThread(long a) {
            super();
            this.a = a;
        }
 
        @Override
        public void run() {
            long count = 0;
            for (int i = 0; i < a; i++) {
                count = count + i;
                for (int j = 0; j < a; j++) {
                    count = count + j;
 
                }
            }
            System.err.println(count + Thread.currentThread().getName() + new Date());
        }
 
    }
 
    @Test
    public void test02() {
        // 比如,要去干封装好的同样的事情
        // 比如有100个数打印
        // 如何让两个线程干这件事呢
        List<Runnable> runnables = new ArrayList<Runnable>();
        CountThread runnable3 = new CountThread(100000);
        CountThread runnable1 = new CountThread(100000);
        CountThread runnable2 = new CountThread(100000);
        runnables.add(runnable3);
        runnables.add(runnable1);
        runnables.add(runnable2);
        for (Runnable runnable : runnables) {
            pool.execute(runnable);
        }
        pool.shutdown();
    }
 
    // 方法测试
    public static void main(String[] args) {
        System.err.println(Thread.currentThread().getName() + new Date());
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.test02();
    }
 
    public void test03() {
        this.test04(100000);
        this.test04(100000);
        this.test04(100000);
 
    }
 
    public void test04(long a) {
        long count = 0;
        for (int i = 0; i < a; i++) {
            count = count + i;
            for (int j = 0; j < a; j++) {
                count = count + j;
 
            }
        }
        System.err.println(count);
    }
 
}