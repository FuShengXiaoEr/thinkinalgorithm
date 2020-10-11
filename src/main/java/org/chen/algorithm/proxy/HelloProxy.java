package org.chen.algorithm.proxy;

/**
 * 静态代理
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-09-21 07:24
 */
public class HelloProxy implements HelloInterface {
    private HelloInterface helloInterface = new Hello();

    @Override
    public void sayHello() {
        System.out.println("Before invoke sayHello");
        helloInterface.sayHello();
        System.out.println("After invoke sayHello");
    }

    public static void main(String[] args) {
        HelloProxy hello = new HelloProxy();
        hello.sayHello();
    }
}
