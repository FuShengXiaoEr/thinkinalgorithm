package org.chen.algorithm.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-18 08:55
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyThread m = new MyThread();
//        m.start();
//
//        MyRunnable myRunnable  = new MyRunnable();
//        Thread thread = new Thread(myRunnable);
//        // 调用的是MyRunnable中的run方法
//        thread.start();

        // 带有返回值
        MyCallable<String> myCallable = new MyCallable<>();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask).start();
        String result = futureTask.get();
        System.out.println(result);

    }
}
