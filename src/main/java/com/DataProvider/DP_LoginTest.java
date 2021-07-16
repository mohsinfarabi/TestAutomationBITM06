package com.DataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DP_LoginTest {
    WebDriver driver;
    String BaseURL = "https://demo.opencart.com/index.php?route=account/login";

    @DataProvider(name = "Invalid_LoginData")
    public Object [][] data(){
        Object [][] data = new Object[3][2]; // RC, Row, Column

        //set 1
        data[0][0]= "mail@mail.com";
        data[0][1]= "123456";

        //set 2
        data[1][0]= "mai2@mail.com";
        data[1][1]= "";

        //set 3
        data[2][0]= "";
        data[2][1]= "123456";

        return data;
    }

    @BeforeClass
    public void browserConfig(){

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");

    }

    @BeforeMethod
    public void launchBrowser(){
        driver = new FirefoxDriver(); // Constructor of FirefoxDriver Class
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

    @AfterClass
    public void testDone(){
        System.out.println("Test Complete .........");
    }

    @Test(dataProvider = "Invalid_LoginData")
    public void loginTest(String DP_Email, String DP_Pass){

        driver.get(BaseURL);

        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Action
        //Email
        email.clear();
        email.sendKeys(DP_Email);

        //Password
        password.clear();
        password.sendKeys(DP_Pass);

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

    }
}
