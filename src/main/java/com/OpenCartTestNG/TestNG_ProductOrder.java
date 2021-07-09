package com.OpenCartTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_ProductOrder extends BaseOpenCart{

    @BeforeClass
    public static void beforeClass(){
        openURL("https://demo.opencart.com/index.php");
    }

    @Test
    public static void orderProduct(){
        WebElement productMac = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div[3]/button[1]"));
        WebElement addToCart = driver.findElement(By.cssSelector("#content > div:nth-child(3) > div > div > div:nth-child(2) > div.button-group > button:nth-child(1)"));
        WebElement goCart = driver.findElement(By.cssSelector("#cart > button"));
        WebElement showCart = driver.findElement(By.cssSelector("#cart > ul > li:nth-child(2) > div > p > a:nth-child(1) > strong"));

        productMac.click();
        addToCart.click();
        goCart.click();
        showCart.click();
    }
}
