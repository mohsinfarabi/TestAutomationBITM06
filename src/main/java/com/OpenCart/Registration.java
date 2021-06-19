package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Registration extends TestBase {

    public static void main(String[] args) {

        firefoxLaunch();
        openURL("https://demo.opencart.com/index.php?route=account/register");
        validRegistration();
        closeBrowser();
    }


    //Random String Generator
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

    public static void validRegistration(){

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
        email.sendKeys(name()+"@gmail.com");
        telephone.sendKeys("12323");
        password.sendKeys("123456");
        confirmPassword.sendKeys("123456");
        privacyCheckbox.click();
        continueButton.click();

    }
}
