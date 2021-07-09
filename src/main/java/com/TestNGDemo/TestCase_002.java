package com.TestNGDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase_002  extends BaseTestNG{


    @BeforeClass
    public static void beforeClassTestCase_002(){
        System.out.println("I am from before TC_002");
    }

    @AfterClass
    public static void afterClassTestCase_002(){
        System.out.println("I am from after TC_002");
    }

    @Test
    public static void Test2(){
        System.out.println("I am from Testcase_002");
    }
}
