package com.Screenshots;

import com.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class PageScreenshot extends TestBase {
    public static void main(String[] args) throws IOException {
        chromeLaunch();
        openURL("https://demo.opencart.com/");
        //screenShot("Page Image");
        fullscreenShot("Full Page");
        closeBrowser();

    }

    public static void  screenShot(String name) throws IOException {
        //Take Screenshot
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        //Save image
        FileUtils.copyFile(srcFile,new File(System.getProperty("user.dir")+"//src//main//Screenshots//"+name+".png"), true);
    }

    public static void  fullscreenShot(String name) throws IOException {
        //Take Screenshot

        Screenshot fullPage = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);

        //Save Image
        ImageIO.write(fullPage.getImage(),"png", new File(System.getProperty("user.dir")+"//src//main//Screenshots//"+name+".png"));

    }
}
