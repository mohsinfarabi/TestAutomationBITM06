package com.TestNGDemo;

import org.testng.annotations.*;

public class BaseTestNG {

    @BeforeSuite
    public static void setUpSuite(){

        System.out.println("I am from BeforeSuite");



    }

    @AfterSuite
    public static void completeSuite(){

        System.out.println("I am from AfterSuite");
    }

  /*  @Test
    public static void TC_001(){

        System.out.println("I am from @Test Annotation");
    }

    @BeforeClass
    public static void beforeClass(){

        System.out.println("Before");

    }
    @AfterClass
    public static void  afterClass(){

        System.out.println("After");
    }*/
}
