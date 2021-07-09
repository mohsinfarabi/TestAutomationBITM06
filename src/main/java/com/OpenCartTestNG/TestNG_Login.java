package com.OpenCartTestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Login extends BaseOpenCart {

    @BeforeClass
    public static void beforeClass(){
        openURL("https://demo.opencart.com/index.php?route=account/login");
    }

    @Test (priority = 1, description = "Login with Invalid Email")
    public static void TC_Login_Invalid_001(){

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Action
        //Email
        email.clear();
        email.sendKeys("email@mail.com");

        //Password
        password.clear();
        password.sendKeys("123456");

        //Login
        loginButton.click();

        String Exp_Title = "Account Login";
        String Act_Title = driver.getTitle();

        //step 3 : compare
        if (Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for InValid test Data");
        }
        else {
            System.out.println("Test FAILED!! for InValid test Data");
        }

        System.out.println("Test Case 001 Executed");
    }

    @Test (priority = 4, description = "Login with valid data")
    public static void TC_Login_Valid_002(){

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Action

        //Email
        email.clear();
        //email.sendKeys("user101@gmail.com");
        email.sendKeys(emailInfo);
        System.out.println(email);
        //Password
        password.clear();
        password.sendKeys("123456");

        //Login
        loginButton.click();

        String Exp_Title = "Account Login";
        String Act_Title = driver.getTitle();

        //step 3 : compare
        if (!Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for Valid test Data");
        }
        else {
            System.out.println("Test FAILED!! for Valid test Data");
        }

        System.out.println("Test Case 002 Executed");
    }

    @Test (priority = 2, description = "Login with blank email")
    public static void TC_Login_Invalid_003(){

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Action

        //Email
        email.clear();
        email.sendKeys("");

        //Password
        password.clear();
        password.sendKeys("123456");

        //Login
        loginButton.click();

        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for InValid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }

        System.out.println("Test Case 003 Executed");
    }

    @Test (priority = 3, description = "Login with blank email and password")
    public static void TC_Login_Invalid_004(){

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Action

        //Email
        email.clear();
        email.sendKeys("");

        //Password
        password.clear();
        password.sendKeys("");

        //Login
        loginButton.click();


        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        //step 3: Compare
        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for InValid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }

        System.out.println("Test Case 004 Executed");
    }

}
