package org.chen.algorithm.concurrency;

import java.util.concurrent.SynchronousQueue;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-18 11:05
 */
public class SynChronousQueueTest {
    public static void main(String[] args) throws InterruptedException {
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Put Thread start:");
                try {
                    queue.put(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Put thread end");
            }
        });

        Thread getThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Get Thread start:");
                try {
                    System.out.println("take from putThread:" + queue.take());
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("Get thread end");
            }
        });

        putThread.start();
        Thread.sleep(1000);
        getThread.start();
    }
}
