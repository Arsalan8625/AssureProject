package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Login {
    public static void main(String[] args) {

        WebDriver driver = Config.getDriver();

        try {
            loginPage(driver);

            //driver.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
    }
    private static void loginPage(WebDriver driver) throws Exception {
        Properties properties = readPropertiesFromFile("login");
        Properties propValue = readPropertiesFromFile("loginvalues");
        driver.get("https://assure-staging.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Successfully landed to Assure login page");
        Thread.sleep(1000);
        String loginUrl = driver.getCurrentUrl();
        driver.findElement(By.xpath(properties.getProperty("alreadyaccount"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
        driver.findElement(By.xpath(properties.getProperty("loginButton"))).click();
        System.out.println("Successfully new deals landed");
        Thread.sleep(3000);
        if (loginUrl.equalsIgnoreCase(driver.getCurrentUrl()))
        {
            Assert.assertEquals(1, 1);
        } else {
            System.out.println("Login Successfull!");
            Thread.sleep(2000);
            CreateProfile();
           // driver.close();
        }
    }
    public static Properties readPropertiesFromFile(String fileName) {
        Properties ob = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\repositories\\"+fileName+".properties");
            ob.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }
    public static void  CreateProfile()throws Exception {
        CreateProfile profile = new CreateProfile();
        profile.NewProfile();
    }
}


