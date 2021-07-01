package com.Screenshots;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class PageScreenshot extends TestBase {
    public static void main(String[] args) throws IOException {
        chromeLaunch();
        openURL("https://google.com");
        screenShot("Page Image");
        closeBrowser();

    }

    public static void  screenShot(String name) throws IOException {
        //Take Screenshot
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Save image
        FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"//src//main//Screenshots//"+name+".png"), true);
    }
}
