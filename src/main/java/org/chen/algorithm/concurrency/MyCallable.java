package org.chen.algorithm.concurrency;

import java.util.concurrent.Callable;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-18 09:32
 */
public class MyCallable<String> implements Callable<String> {
    private int ticket = 10;
    @Override
    public String  call() throws Exception {
        while(ticket > 0){
            System.out.println("票还剩余：" + ticket);
            ticket--;
        }
        return (String) "票已卖光";
    }
}
