package org.chen.algorithm.collection.set;

import java.util.Set;
import java.util.TreeSet;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-17 17:33
 */
public class TreeSetSort {
    public static void main(String[] args) {
        Child child1 = new Child(1, 14);
        Child child2 = new Child(2, 12);
        Child child3 = new Child(3, 10);

        Set<Child> treeSet = new TreeSet<>();
//        treeSet.add(child1);
//        treeSet.add(child2);
//        treeSet.add(child3);

        Student st1 = new Student(12, "xiaoming");
        Student st2 = new Student(13, "xiaohua");
        Student st3 = new Student(14, "xiaoji");
        Set<Student> treeSet1 = new TreeSet<>();
        treeSet1.add(st1);
        treeSet1.add(st2);
        treeSet1.add(st3);

        treeSet1.stream().forEach(System.out::println);

    }
}
