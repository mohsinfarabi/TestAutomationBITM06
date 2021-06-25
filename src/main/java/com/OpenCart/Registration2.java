package com.OpenCart;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class Registration2 extends TestBase {

    public static void main(String[] args) {
           chromeLaunch();
           openURL("https://demo.opencart.com/index.php?route=account/register");

           validRegistration();
           InvalidRegistration();

    }
     protected static String name(){
       String SALTCHAR="abcdefghijABCDEFGH123";
        StringBuilder salt=new StringBuilder();
        Random rnd=new Random();

        while(salt.length()<10){
            int index=(int)(rnd.nextFloat()*SALTCHAR.length());
            salt.append(SALTCHAR.charAt(index));
        }
        String saltStr=salt.toString();
        return saltStr;
     }
    public static void InvalidRegistration() {
        driver.manage().deleteAllCookies();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        firstName.sendKeys("Muntasir");
        lastName.sendKeys("Abdullah");
        email.clear();
        email.sendKeys("user101@gmail.com");
        telephone.sendKeys("12323");
        password.sendKeys("123456");
        confirmPassword.sendKeys("123456");
        privacyCheckbox.click();
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

    public static void validRegistration() {
        driver.manage().deleteAllCookies();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        firstName.sendKeys("Muntasir");
        lastName.sendKeys("Abdullah");
        email.clear();
        email.sendKeys(name()+"@gmail.com");
        telephone.sendKeys("12323");
        password.sendKeys("123456");
        confirmPassword.sendKeys("123456");
        privacyCheckbox.click();
        continueButton.click();

        String Exp_Title="Account Login";
        String Act_Title=driver.getTitle();

        if(!Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for Valid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }

        driver.findElement(By.linkText("Logout")).click();

        driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
        driver.findElement(By.linkText("Register")).click();

    }


}
