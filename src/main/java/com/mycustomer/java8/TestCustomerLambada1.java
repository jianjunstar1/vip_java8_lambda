package com.mycustomer.java8;

import com.atguigu.java8.Employee;
import com.mycustomer.java8.innerclass.CustomerFilterEmplyeeAge;
import com.mycustomer.java8.innerclass.MyCustomerPredicate;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestCustomerLambada1 {


    public void comparator() {
        Comparator<String> cc = new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };


    }

    @Test
    public void test1() {
        comparator();
    }

    List<CustomEmployee> employeeList = Arrays.asList(
            new CustomEmployee(101, "张三", 18, 9999.99),
            new CustomEmployee(102, "李四", 59, 6666.66),
            new CustomEmployee(103, "王五", 28, 3333.33),
            new CustomEmployee(104, "赵六", 8, 7777.77),
            new CustomEmployee(105, "田七", 38, 5555.55)
    );


    @Test
    public void test2() {
        List<CustomEmployee> list = filterEmployeeAge(employeeList);
        for (CustomEmployee employee : list) {
            System.out.println(employee);
        }
    }

    //需求：获取公司中年龄小于 35 的员工信息
    public List<CustomEmployee> filterEmployeeAge(List<CustomEmployee> emps) {
        List<CustomEmployee> list = new ArrayList<>();

        for (CustomEmployee employee : emps) {
            if (employee.getAge() <= 35){
                list.add(employee);
            }
        }

        return list;
    }

    @Test
    public void test3() {
        List<CustomEmployee> list = filterEmploySalary(employeeList);
        for (CustomEmployee employee : list) {
            System.out.println(employee);
        }
    }

    //需求：获取公司中工资大于 5000 的员工信息
    public List<CustomEmployee> filterEmploySalary(List<CustomEmployee> emps) {
        List<CustomEmployee> list = new ArrayList<>();

        for (CustomEmployee employee : emps) {
            if (employee.getSalary() > 5000){
                list.add(employee);
            }
        }

        return list;
    }

    //优化方式一：策略设计模式
    public List<CustomEmployee> filterEmployee(List<CustomEmployee> employees, MyCustomerPredicate<CustomEmployee> predicate) {
        List<CustomEmployee> list = new ArrayList<>();

        for (CustomEmployee employee : employees) {
            if (predicate.test(employee)) {
                list.add(employee);
            }

        }

        return list;
    }

    @Test
    public void test4() {
        List<CustomEmployee> list = filterEmployee(employeeList, new CustomerFilterEmplyeeAge());
        for (CustomEmployee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式二：匿名内部类
    @Test
    public void test5() {
        List<CustomEmployee> list = filterEmployee(employeeList, new MyCustomerPredicate<CustomEmployee>() {
            @Override
            public boolean test(CustomEmployee customEmployee) {
                return customEmployee.getAge() <= 35;
            }
        }) ;

        for (CustomEmployee employee : list) {
            System.out.println(employee);
        }
    }

    //优化方式三：Lambda 表达式
    @Test
    public void test6() {
        List<CustomEmployee> list = filterEmployee(employeeList, (e)-> e.getAge() <= 35);
        list.forEach(System.out::println);

        System.out.println("-------------------------------");
        List<CustomEmployee> list2 = filterEmployee(employeeList, (e)->e.getSalary() >= 5000);
        list.forEach(System.out::println);

    }

    //优化方式四：Stream API
    @Test
    public void test7() {
        employeeList.stream()
                .filter((e)->e.getAge() <= 35)
                .forEach(System.out::println);
        System.out.println("-------------------------------");

        employeeList.stream()
                .map(CustomEmployee::getName)
                .limit(3)
                .forEach(System.out::println);
    }
}
