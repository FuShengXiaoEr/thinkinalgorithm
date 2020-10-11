package org.chen.algorithm.proxy;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-09-21 07:22
 */
public class Hello implements HelloInterface {
    @Override
    public void sayHello() {
        System.out.println("Hello CHEN");
    }
}
