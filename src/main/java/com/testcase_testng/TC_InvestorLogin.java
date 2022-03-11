package com.testcase_testng;

import com.assure.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

public class TC_InvestorLogin {
    WebDriver driver = Config.getDriver();

    @BeforeTest
    void OpenBrowser() throws InterruptedException {
        driver.get("https://assure-staging.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Successfully landed to login page");
        Thread.sleep(2000);
    }
    @Test(priority = 4)
    void loginwithvalidemailpassword() throws Exception {
        Properties properties = readPropertiesFromFile("TC_InvestorLogin");
        Properties propValue = readPropertiesFromFile("TC_InvestorLoginvalues");
        driver.get("https://assure-staging.herokuapp.com/");
        driver.findElement(By.xpath(properties.getProperty("alreadyaccount"))).click();
        Thread.sleep(3000);
        // clearFields();
        driver.findElement(By.xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
        driver.findElement(By.xpath(properties.getProperty("loginButton"))).click();
        System.out.println("Successfully landed to dashboard");
        Thread.sleep(2000);

    }
    @Test(priority = 1)
    void passwordfieldempty() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorLogin");
        Properties propValue = readPropertiesFromFile("TC_InvestorLoginvalues");
        driver.get("https://assure-staging.herokuapp.com/");
        driver.findElement(By.xpath(properties.getProperty("alreadyaccount"))).click();
        Thread.sleep(3000);
        //clearFields();
        driver.findElement(By.xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        //driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
        driver.findElement(By.xpath(properties.getProperty("loginButton"))).click();
        // Assert.assertEquals(false,true);
        System.out.println("Password field required");
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    void emailpasswordempty() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorLogin");
        Properties propValue = readPropertiesFromFile("TC_InvestorLoginvalues");
        driver.get("https://assure-staging.herokuapp.com/");
        driver.findElement(By.xpath(properties.getProperty("alreadyaccount"))).click();
        Thread.sleep(3000);
        // clearFields();
        //driver.findElement(By.xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        //driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
        driver.findElement(By.xpath(properties.getProperty("loginButton"))).click();
        // Assert.assertEquals(false,true);
        System.out.println("Password/email field required");
        Thread.sleep(2000);
    }
    @Test(priority = 3)
    void emailfieldempty() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorLogin");
        Properties propValue = readPropertiesFromFile("TC_InvestorLoginvalues");
        driver.get("https://assure-staging.herokuapp.com/");
        driver.findElement(By.xpath(properties.getProperty("alreadyaccount"))).click();
        Thread.sleep(3000);
        // clearFields();
        //driver.findElement(By.xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
        driver.findElement(By.xpath(properties.getProperty("loginButton"))).click();
        // Assert.assertEquals(false,true);
        System.out.println("email field required");
        Thread.sleep(2000);

    }

    private void clearFields() {
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("password")).clear();
    }
    public static Properties readPropertiesFromFile(String fileName) {
        Properties ob = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Testcaserepositories\\"+fileName+".properties");
            ob.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;
    }
}
