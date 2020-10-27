package org.chen.algorithm.enumtest;

public enum Day2 {
    MONDAY("星期一",1),
    TUESDAY("星期二",2),
    WEDNESDAY("星期三",3),
    THURSDAY("星期四",4),
    FRIDAY("星期五",5),
    SATURDAY("星期六",6),
    SUNDAY("星期天",7);
    private String desc;
    private int num;
    public String getDesc(){
        return this.desc;
    }
    public int getNum(){
        return this.num;
    }
    public void setDesc(String desc){
        this.desc = desc;
    }
    public void setNum(int num){
        this.num = num;
    }
    Day2(String desc, int num){
        this.desc = desc;
        this.num = num;
    }
}
