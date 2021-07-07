package com.TestNGDemo;

import org.testng.annotations.*;

public class BasicTestNG {

    @BeforeSuite
    public static void setUpSuite(){



    }

    @AfterSuite
    public static void completeSuite(){

    }

    @Test
    public static void TC_001(){

        System.out.println("I am from @Test Annotation");
    }
}
