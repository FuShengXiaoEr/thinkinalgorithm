package org.chen.algorithm.reflect;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-09-20 13:31
 */
public class Person {
    private int age;
    private String name;

    public Person() {
    }

    ;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
