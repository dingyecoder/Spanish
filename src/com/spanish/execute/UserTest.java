package com.spanish.execute;

import org.junit.Test;

public class UserTest {



    @Test
    public  void testEqual(){
        String password = "aaa";
        String repasswd = "aaa";
        System.out.println(password.equals(repasswd));
    }

}
