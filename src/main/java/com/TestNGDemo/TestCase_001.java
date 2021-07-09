package com.TestNGDemo;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCase_001 extends BaseTestNG {

    @BeforeMethod
    public static void  beforeTest1(){
        System.out.println("I am from before test1");
    }

    @AfterMethod
    public static void  afterTest1(){
        System.out.println("I am after test1");
    }

    @Test
    public static void Test1(){

        System.out.println("I am from Testcase_001");
    }
}
