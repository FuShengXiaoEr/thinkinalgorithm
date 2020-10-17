package org.chen.algorithm.collection.set;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-17 17:35
 */
class Student implements Comparable<Student> {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student o) {
        Student st = (Student) o;
        if (this.age > st.getAge()) {
            return 1;
        } else if (this.age < st.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
