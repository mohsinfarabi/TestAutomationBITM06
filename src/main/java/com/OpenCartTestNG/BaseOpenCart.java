package com.OpenCartTestNG;

import com.Base.TestBase;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.Random;



public class BaseOpenCart extends TestBase {

    public static String emailInfo =  name()+"@gmail.com";

    @BeforeSuite
    public static void beforeSuite(){
        firefoxLaunch();

    }


    @BeforeSuite
    protected static String name(){

        String SALTCHAR= "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while(salt.length()<10){
            int index=(int)(rnd.nextFloat()*SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));
        }

        String saltStr= salt.toString();
        return saltStr;

    }


    @AfterSuite
    public static void completeSuite(){
        closeBrowser();
    }
}
