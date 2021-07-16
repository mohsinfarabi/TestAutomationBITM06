package com.Cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class LoginStep {

    WebDriver driver;

    @Given("Open Browser and Navigate to Login page")
    public void open_browser_and_navigate_to_login_page() {
        // Write code here that turns the phrase above into concrete actions
        //set driver path: dynamic
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"//src//main//resources//geckodriver.exe");
        driver = new FirefoxDriver(); // Constructor of FirefoxDriver ClassS
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }

    @When("Enter valid Email and Password")
    public void enter_valid_email_and_password() {
        // Write code here that turns the phrase above into concrete actions
        WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        WebElement loginButton = driver.findElement(By.cssSelector("#content > div > div:nth-child(2) > div > form > input"));

        //Action
        //Email
        email.clear();
        email.sendKeys("user101@gmail.com");

        //Password
        password.clear();
        password.sendKeys("123456");

        //Login
        loginButton.click();
    }

    @Then("Login Successful and Close Test")
    public void login_successful_and_close_test() {
        // Write code here that turns the phrase above into concrete actions
        String Exp_Title = "My Account";
        String Act_Title = driver.getTitle();

        //step 3 : compare
        Assert.assertEquals(Exp_Title,Act_Title);

        driver.close();
        }
    }
