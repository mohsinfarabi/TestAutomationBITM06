package com.OpenCartTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNG_Registration extends BaseOpenCart {


    @BeforeMethod
    public static void beforeMethod(){
        openURL("https://demo.opencart.com/index.php?route=account/register");
    }

    @Test (description = "Invalid Registration")
    public static void InvalidRegistration() {
        driver.navigate().refresh();
        driver.manage().deleteAllCookies();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        firstName.clear();
        firstName.sendKeys("Mohsin");

        lastName.clear();
        lastName.sendKeys("Farabi");

        email.clear();
        email.sendKeys("user101@gmail.com");

        telephone.clear();
        telephone.sendKeys("12323");

        password.clear();
        password.sendKeys("123456");

        confirmPassword.clear();
        confirmPassword.sendKeys("123456");

        if(!privacyCheckbox.isSelected()){
            privacyCheckbox.click();
        }
        else{
            System.out.println("Already cHecked");
        }

        continueButton.click();

        String Exp_Title="Register Account";
        String Act_Title=driver.getTitle();

        if(Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for InValid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }

    }

    @Test (description = "Valid Registration")
    public static void validRegistration() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        firstName.clear();
        firstName.sendKeys("Mohsin");
        lastName.clear();
        lastName.sendKeys("Farabi");
        email.clear();
        email.sendKeys(emailInfo);
        telephone.clear();
        telephone.sendKeys("12323");
        password.clear();
        password.sendKeys("123456");
        confirmPassword.clear();
        confirmPassword.sendKeys("123456");

        if(!privacyCheckbox.isSelected()){
            privacyCheckbox.click();
        }
        else{
            System.out.println("Already cHecked");
        }

        continueButton.click();

        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        if(!Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for Valid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }

        //Logout
        driver.findElement(By.linkText("Logout")).click();

        //Open Register page
        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Register")).click();

    }


}
