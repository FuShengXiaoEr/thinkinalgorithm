package org.chen.algorithm.reflect;

import java.lang.reflect.*;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-09-20 13:26
 */
public class ReflectionDemo {
    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        demo1();
        System.out.println("========================");

        demo2();
        System.out.println("========================");

        demo3();
        System.out.println("========================");

        demo4();
        System.out.println("========================");

        demo5();
        System.out.println("========================");
//
//        demo6();
//        System.out.println("========================");
//
//        demo7();
//        System.out.println("========================");
//
//        demo8();
//        System.out.println("========================");
    }

    public static void demo1() {
        Person person = new Person();
        System.out.println("demo1包名：" + person.getClass().getPackage().getName() + "," +
                "完整类名" + person.getClass().getName());
    }

    /**
     * Demo2: 验证所有的类都是Class类的实例对象
     *
     * @throws ClassNotFoundException
     */
    public static void demo2() throws ClassNotFoundException {
        Class<?> class1 = null;
        Class<?> class2 = null;

        class1 = Class.forName("org.chen.algorithm.reflect.Person");
        System.out.println("demo2包名：" + class1.getClass().getPackage().getName() + "," +
                "完整类名" + class1.getClass().getName());

        class2 = Person.class;
        System.out.println("demo2包名：" + class2.getClass().getPackage().getName() + "," +
                "完整类名" + class2.getClass().getName());
    }

    public static void demo3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class<?> class1 = null;
        class1 = Class.forName("org.chen.algorithm.reflect.Person");

        Person person = (Person) class1.newInstance();
        person.setAge(20);
        person.setName("aaa");
        System.out.println("demo3:" + person.getName() + person.getAge());
    }

    public static void demo4() throws ClassNotFoundException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        Class<?> class1 = null;
        Person person1 = null;
        Person person2 = null;
        class1 = Class.forName("org.chen.algorithm.reflect.Person");
        Constructor<?>[] constructor = class1.getConstructors();

        person1 = (Person)constructor[0].newInstance();
        person1.setName("bbbb");
        person1.setAge(11);

        person2 = (Person) constructor[1].newInstance(20,"cccc");
        System.out.println("Demo4:"+person1.getName()+person1.getAge()+person2.getName()+person2.getAge());
    }

    public static void demo5() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        Class<?> class1 = null;
        class1 = Class.forName("org.chen.algorithm.reflect.Person");
        Object object =class1.newInstance();
        Field personNameField = class1.getDeclaredField("name");
        personNameField.setAccessible(true);
        personNameField.set(object,"dddd");

        System.out.println("Demo5: 修改属性之后得到属性变量的值：" + personNameField.get(object));
    }

    public static void demo6() throws ClassNotFoundException {
        Class<?> class1 = null;
        class1 = Class.forName("org.chen.algorithm.reflect.Person");

        // 取得父类名称
        Class<?> superClass = class1.getSuperclass();
        System.out.println("Demo6:  SuperMan类的父类名: " + superClass.getName());

        System.out.println("===============================================");
        Field[] fields = class1.getFields();
        for (Field field:fields) {
            System.out.println("类中的成员: " + field);
        }

        System.out.println("===============================================");

        // 取得类方法
        Method[] methods = class1.getDeclaredMethods();
        for (Method method:methods) {
            System.out.println("Demo6,取得SuperMan类的方法：");
            System.out.println("函数名：" + method.getName());
            System.out.println("函数返回类型：" + method.getReturnType());
            System.out.println("函数访问修饰符：" + Modifier.toString(method.getModifiers()));
            System.out.println("函数代码写法： " + methods);
        }
    }
}
