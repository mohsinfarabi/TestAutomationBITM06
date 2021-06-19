package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
    public static WebDriver driver;

    public static void  firefoxLaunch(){
        // set driver path: static
        //  System.setProperty("webdriver.gecko.driver", "E:\\SQATest\\Tools\\geckodriver.exe"); //firefox

        //set driver path: dynamic
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver = new FirefoxDriver(); // Constructor of FirefoxDriver Class

        //Maximize Browser Size
        driver.manage().window().maximize();
    }

    public static void chromeLaunch(){

        // set driver path: static
        //  System.setProperty("webdriver.chrome.driver", "E:\\SQATest\\Tools\\chromedriver.exe"); //chrome

        //set driver path: dynamic
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//main//resources//chromedriver.exe");
        driver = new ChromeDriver(); // Constructor of ChromeDriver Class, new = keyWord

        // Maximize Browser Size
        driver.manage().window().maximize();
    }

    public static void  openURL(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.close();
    }
}
