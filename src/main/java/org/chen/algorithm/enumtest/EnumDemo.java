package org.chen.algorithm.enumtest;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-18 07:05
 */
public class EnumDemo {
    public static void main(String[] args) {
        Day[] days = {Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY};
        Arrays.stream(days).forEach(day -> System.out.println(day + ","+ day.ordinal()));

        System.out.println("compareTo------------------");
        System.out.println("day[1] compareTo day[2]:"+days[1].compareTo(days[2]));

        System.out.println("class reference------------------");
        System.out.println(days[1].getDeclaringClass());

        //values方法时编译器生成的static方法，在Enum类中并没有出现，但是有valueof方法
        System.out.println("向上转型后无法直接使用values方法-----------");
        Day[] days1 = Day.values();
        System.out.println("day1:" + Arrays.toString(days1));
        Day day = Day.valueOf("MONDAY");
        System.out.println(day);

        // 无values方法
        Enum enumDay = Day.MONDAY;
        Class<?> clasz = enumDay.getDeclaringClass();
        if (clasz.isEnum()){
            Day[] days2 = (Day[])clasz.getEnumConstants();
            System.out.println( "days2:" + Arrays.toString(days));
        }

        Day2 day2 = Day2.FRIDAY;
        System.out.println("day2:"+day2.getDesc()+ day2.getNum());

    }

}
