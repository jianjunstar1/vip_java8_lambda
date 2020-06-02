package com.mycustomer.java8.innerclass;

public class Chouxiang2 extends Chouxiang {
    String name = "Geek Chouxiang2";//抽象类的属性是不会被调用的，除了方法

    public void say3() {
        System.out.println("这是继承的方法");
    }
}
