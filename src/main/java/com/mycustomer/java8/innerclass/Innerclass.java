package com.mycustomer.java8.innerclass;

public class Innerclass {
    public static void main(String[] args) {
        System.out.println("现在开始匿名内部类程序的编写\n");
        Chouxiang c = new Chouxiang() {
            String name = "Geek Song too";

            public void say3() {
                System.out.println("这是匿名内部类当中的方法，重写了抽象类的方法");
                System.out.println(name);
            }
        };//在使用匿名内部类的时候，当这个类在陈述完之后，是需要打分号的。
        c.say3();
        System.out.println("我们来看看这个name到底是抽象类当中的name还是匿名内部类当中的" + c.name);//结果果然是父类当中的属性，和我们多态的性质相重合了

        System.out.println("---------------------------------------------");


        Chouxiang cc = new Chouxiang2();
        cc.say3();
        System.out.println("我们来看看这个name到底是抽象类当中的name还是匿名内部类当中的" + c.name);//结果果然是父类当中的属性，和我们多态的性质相重合了

    }
}