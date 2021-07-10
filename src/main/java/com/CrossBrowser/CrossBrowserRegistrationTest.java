package com.CrossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.Random;

public class CrossBrowserRegistrationTest {
    WebDriver driver;
    String FirefoxDriverPath = "./src/main/resources/geckodriver.exe";
    String ChromeDriverPath = "./src/main/resources/chromedriver.exe";
    String BaseURL = "https://demo.opencart.com/index.php?route=account/register";
    String emailInfo = name()+"@gmail.com";

    @BeforeTest
    @Parameters("Browser")
    public void Setup(String browser) throws Exception {
        if(browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", FirefoxDriverPath);
            driver = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
            driver = new ChromeDriver();
        }

        else {
            throw new Exception("Browser Not FOUND!!!!");
        }
    }


    @DataProvider(name = "InvalidRegistrationData")
    public Object [][] data(){
        Object [][] data = new Object[4][2]; // RC, Row, Column

        //set 1
        data[0][0]= "mail@mail.com";
        data[0][1]= "Testing";

        //set 2
        data[1][0]= "mai2@mail.com";
        data[1][1]= "";

        //set 3
        data[2][0]= "";
        data[2][1]= "Test0";

        //set 4
        data[3][0]= "";
        data[3][1]= "";



        return data;
    }

    @DataProvider(name = "ValidRegistrationData")
    public Object [][] data2(){
        Object [][] data2 = new Object[1][2]; // RC, Row, Column

        //set 4
        data2[0][0]= emailInfo;
        data2[0][1]= "TestE";



        return data2;
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

    @Test (dataProvider = "InvalidRegistrationData")
    public void invalidRegistrationTest(String DP_Email, String DP_FirstName){

        driver.get(BaseURL);

        driver.manage().deleteAllCookies();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        firstName.sendKeys(DP_FirstName);
        lastName.sendKeys("Abdullah");
        email.clear();
        email.sendKeys(DP_Email);
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

    @Test (dataProvider = "ValidRegistrationData")
    public void validRegistrationTest(String DP_Email, String DP_FirstName){

        driver.get(BaseURL);

        driver.manage().deleteAllCookies();
        WebElement firstName = driver.findElement(By.xpath("//input[@id='input-firstname']"));
        WebElement lastName = driver.findElement(By.xpath("//input[@id='input-lastname']"));
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement telephone = driver.findElement(By.xpath("//input[@id='input-telephone']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement confirmPassword = driver.findElement(By.xpath("//input[@id='input-confirm']"));
        WebElement privacyCheckbox = driver.findElement(By.cssSelector("#content > form > div > div > input[type=checkbox]:nth-child(2)"));
        WebElement continueButton = driver.findElement(By.cssSelector("#content > form > div > div > input.btn.btn-primary"));

        firstName.sendKeys(DP_FirstName);
        lastName.sendKeys("Abdullah");
        email.clear();
        email.sendKeys(DP_Email);
        telephone.sendKeys("12323");
        password.sendKeys("123456");
        confirmPassword.sendKeys("123456");
        privacyCheckbox.click();
        continueButton.click();

        String Exp_Title="Register Account";
        String Act_Title=driver.getTitle();

        if(!Exp_Title.equals(Act_Title)){
            System.out.println("Test PASSED!! for Valid test Data");
        }
        else {
            System.out.println("Test Failed!! for InValid test Data");
        }

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
