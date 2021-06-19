package com.WebDriverBasic;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationTest extends TestBase {

    public static void main(String[] args) {

        firefoxLaunch();
        openURL("https://demo.opencart.com/index.php?route=account/register");

        TC_Registration_Valid001();
    }

    public static void  TC_Registration_Valid001(){
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        firstName.clear();
        firstName.sendKeys("User2");

        lastName.clear();
        lastName.sendKeys("UserLast");

        //email
        email.clear();
        email.sendKeys("tugeipissepu-4336@yopmail.com");

        telephone.clear();
        telephone.sendKeys("198745612563");

        //Password
        password.clear();
        password.sendKeys("123456");

        //Password
        confirmPassword.clear();
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

        System.out.println("Test Case 001 Executed");
    }
}
