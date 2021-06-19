package com.TestCases;

import com.Base.TestBase;

public class TestCase001 extends TestBase{ //Inheritance

    public static void main(String[] args) {
        firefoxLaunch();
        openURL("https://bbc.com");
        closeBrowser();
    }
}
