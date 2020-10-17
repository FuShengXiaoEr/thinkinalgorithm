package org.chen.algorithm.concurrency;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-12 05:32
 */
public class SynchronizedExample {
    private int value = 0;
    private int getNext(){
        return value++;
    }

    public static void main(String[] args) {
        SynchronizedExample s = new SynchronizedExample();
        for (int i = 0 ;i < 100000;i++){
            s.getNext();
        }
        System.out.println(s.value);
        for (int i = 0 ;i < 100000;i++){
            s.getNext();
        }
        System.out.println(s.value);
    }
}
class ThreadTest implements Runnable{
    @Override
    public void run() {

    }
}