package com.assure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Config {
    public static WebDriver driver;
    public Config(){

    }

    public static WebDriver getDriver(){
        if(driver==null){
            System.setProperty("webdriver.chrome.driver","E:\\selenium_Java Jar Files\\Latest ChromeDriver 99\\chromedriver.exe");
            driver =  new ChromeDriver();

        }
        return driver;
    }
}
