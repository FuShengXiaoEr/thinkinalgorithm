package org.chen.algorithm.collection.set;

/**
 * @program: thinkinalgorithm
 * @author: CHENMEIPENG
 * @create: 2020-10-17 17:35
 */
class Child {
    private Integer id;
    private Integer age;

    public Child() {
    }

    public Child(Integer id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
