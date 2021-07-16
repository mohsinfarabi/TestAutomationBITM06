package com.DataDriven;

import com.Base.TestBase;
import com.utils.Excel.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DD_LoginTest extends TestBase {

    @BeforeMethod
    public void browserConfig(){
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver=new FirefoxDriver();
    }

    @Test
    public void loginTest(){
        driver.get("https://demo.opencart.com/index.php?route=account/login");

        //Excel Implementation
        Xls_Reader reader=new Xls_Reader("./src/main/resources/LoginData.xlsx");
        String sheetName="Sheet1";

        int rowCount= reader.getRowCount(sheetName);

        for(int rowNum=2; rowNum<=rowCount;rowNum++){
            String emailData=reader.getCellData(sheetName,"Email",rowNum);
            String pswrd=reader.getCellData(sheetName,"Password",rowNum);

            WebElement Email = driver.findElement(By.xpath("//input[@id='input-email']"));
            WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
            WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

            // Action
            //Email
            Email.clear();
            Email.sendKeys(emailData);

            //Password
            password.clear();
            password.sendKeys(pswrd);

            //Login Button
            loginButton.click();

        }
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
