package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class UserNavigation extends TestBase {

    public static String emailInfo =  name()+"@gmail.com"; // setting the randomly generated email id to a variable;

    public static void main(String[] args) {

        firefoxLaunch();
        openURL("https://demo.opencart.com/index.php?route=account/register");
        TC_Registration_Valid();
        TC_Logout_Valid();
        TC_Login_Valid();
        TC_Logout_Valid();

        closeBrowser();


    }

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

    public static void  TC_Registration_Valid(){
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        firstName.sendKeys("Mohsin");
        lastName.sendKeys("Farabi");
        //email.sendKeys(name()+"@gmail.com");
        email.sendKeys(emailInfo);
        telephone.sendKeys("12323");
        password.sendKeys("123456");
        confirmPassword.sendKeys("123456");
        privacyCheckbox.click();
        continueButton.click();

        String expUrl = "https://demo.opencart.com/index.php?route=account/success";

        String actUrl = driver.getCurrentUrl();


        if (expUrl.equals(actUrl)){
            System.out.println("Test PASSED!! Registration Successful");
        }
        else {
            System.out.println("Test FAILED!! Registration Failed");
        }

        System.out.println("Email ID is: "+ emailInfo);
        System.out.println("Test Case Registration Executed");
    }

    public static void TC_Login_Valid(){

        openURL("https://demo.opencart.com/index.php?route=account/login");

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Action

        System.out.println("Email ID is: "+ emailInfo);

        //Email
        email.clear();
        //email.sendKeys(name()+"@gmail.com");
        email.sendKeys(emailInfo);

        //Password
        password.clear();
        password.sendKeys("123456");

        //Login
        loginButton.click();

        String Exp_Title = "My Account";
        String Act_Title = driver.getTitle();

        //step 3 : compare
        if (Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for Valid test Data");
        }
        else {
            System.out.println("Test FAILED!! for Valid test Data");
        }

        System.out.println("Test Case Login Executed");
    }

    public static void TC_Logout_Valid(){


        openURL("https://demo.opencart.com/index.php?route=account/account");


        WebElement myAccount = driver.findElement(By.linkText("My Account"));
        WebElement logout = driver.findElement(By.linkText("Logout"));



        myAccount.click();
        logout.click();

        String exp_URL = "https://demo.opencart.com/index.php?route=account/logout";
        String act_URL = driver.getCurrentUrl();

        if(exp_URL.equals(act_URL)){
            System.out.println("Test Passed!!! Logout Successful");
        }
        else {
            System.out.println("Test Failed!!! Logout Failed");
        }

        System.out.println("Test Case Logout Executed");

    }
}
