package org.chen.algorithm.collection.set;

import java.util.Arrays;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-17 16:41
 */
public class TreeSetCompareTo {
    public static void main(String[] args) {
        Student st1 = new Student(12, "xiaoming");
        Student st2 = new Student(13, "xiaohua");
        Student st3 = new Student(14, "xiaoji");
        Student[] students = {st1, st2, st3};
        Arrays.sort(students);
        Arrays.stream(students).forEach(System.out::println);
    }
}

