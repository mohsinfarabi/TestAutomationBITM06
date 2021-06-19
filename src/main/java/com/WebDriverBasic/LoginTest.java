package com.WebDriverBasic;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends TestBase {

    public static void main(String[] args) {

        firefoxLaunch();
        openURL("https://demo.opencart.com/index.php?route=account/login");

        TC_Login_Invalid_001();
        TC_Login_Valid_002();
        //TC_Login_Invalid_003();
        //TC_Login_Invalid_004();

        closeBrowser();
    }



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

    public static void TC_Login_Valid_002(){

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Action

        //Email
        email.clear();
        email.sendKeys("user101@gmail.com");

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
