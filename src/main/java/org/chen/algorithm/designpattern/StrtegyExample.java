package org.chen.algorithm.designpattern;

import java.sql.Connection;
import java.util.Map;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-11 09:18
 */
public class StrtegyExample {

    public static void main(String[] args) {
        Context context1 = new Context(new FirstStrategy());
        context1.execute();

        Context context2 = new Context(new SecondStrategy());
        context2.execute();
    }
}
interface Strategy{
    void execute();
}
class FirstStrategy implements Strategy{
    @Override
    public void execute(){
        System.out.println("first Stragety");
    }
}

class SecondStrategy implements Strategy{
    @Override
    public void execute() {
        System.out.println("second Stragety");
    }
}
class Context{
    Strategy strategy;
    public Context(Strategy strategy){
        this.strategy = strategy;
    }
    public void execute(){
        this.strategy.execute();
    }
}