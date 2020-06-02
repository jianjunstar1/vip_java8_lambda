package com.mycustomer.java8.innerclass;

import com.mycustomer.java8.CustomEmployee;

public class CustomerFilterEmplyeeAge implements MyCustomerPredicate<CustomEmployee> {


    @Override
    public boolean test(CustomEmployee t) {
        return t.getAge() <= 35;
    }
}
