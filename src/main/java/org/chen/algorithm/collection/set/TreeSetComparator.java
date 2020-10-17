package org.chen.algorithm.collection.set;

import java.util.*;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-17 17:07
 */
public class TreeSetComparator {
    public static void main(String[] args) {
        Child child1 = new Child(1, 14);
        Child child2 = new Child(2, 12);
        Child child3 = new Child(3, 10);

        List<Child> list = new ArrayList<>();
        list.add(child1);
        list.add(child2);
        list.add(child3);

//        Collections.sort(list, new Comparator<Child>() {
//            @Override
//            public int compare(Child o1, Child o2) {
//                return o1.getAge() > o2.getAge() ? 1 : (o1.getAge() < o2.getAge() ? -1 : 0);
//            }
//        });

//        list.stream().forEach(System.out::println);

        Comparator<Child> comparator = Comparator.comparingInt(x -> x.getId());
        Collections.sort(list, comparator);
        list.stream().forEach(System.out::println);
        Collections.sort(list, comparator.reversed());
        list.stream().forEach(System.out::println);

    }
}
