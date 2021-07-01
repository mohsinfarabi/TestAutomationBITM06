package com.DropDown;

import com.Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllAboutDropDown extends TestBase {
    public static void main(String[] args) {
        firefoxLaunch();
        openURL("https://the-internet.herokuapp.com/dropdown");
        selectIndex();
        selectValue();
        selectVisibleText();
        closeBrowser();

    }

    public static void  selectIndex(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select obj = new Select(dropDown); //Select class of selenium UI package
        obj.selectByIndex(2); //option 2
    }

    public static void  selectValue(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select obj = new Select(dropDown); //Select class of selenium UI package
        obj.selectByValue("1"); //option 1
    }

    public static void  selectVisibleText(){
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        Select obj = new Select(dropDown); //Select class of selenium UI package
        obj.selectByVisibleText("Option 2"); //option 2
    }


}

