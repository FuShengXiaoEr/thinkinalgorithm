package org.chen.algorithm.concurrency;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-18 09:14
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnable.run()");
    }
}
