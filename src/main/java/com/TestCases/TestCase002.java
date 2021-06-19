package com.TestCases;

import com.Base.TestBase;

public class TestCase002 extends TestBase{ //Inheritance

    public static void main(String[] args) {
        chromeLaunch();
        openURL("https://cnn.com");
        closeBrowser();
    }
}
