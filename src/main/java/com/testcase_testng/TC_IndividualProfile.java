package com.testcase_testng;

import com.assure.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.assure.Config.driver;
import static com.assure.Login.readPropertiesFromFile;

public class TC_IndividualProfile {

    WebDriver driver = Config.getDriver();

    @BeforeTest
    void OpenBrowser() throws InterruptedException {
        driver.get("https://assure-staging.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Successfully landed to login page");
        Thread.sleep(2000);
        Properties properties = readPropertiesFromFile("TC_login");
        Properties propValue = readPropertiesFromFile("TC_loginvalues");
        driver.get("https://assure-staging.herokuapp.com/");
        driver.findElement(By.xpath(properties.getProperty("alreadyaccount"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
        driver.findElement(By.xpath(properties.getProperty("loginButton"))).click();
        System.out.println("Successfully landed to dashboard");
        Thread.sleep(2000);
    }
    @Test(priority = 1)
    void OpenProfile() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_Individual");
        Properties propValue = readPropertiesFromFile("TC_IndividualValues");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath(properties.getProperty("deal"))).click();
        Thread.sleep(5000);
        driver.findElement(By.id(properties.getProperty("createnewprofile"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.id(properties.getProperty("individualprofile"))).click();
        // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("successfully open profile");
        Thread.sleep(5000);
}
    @Test(priority =3)
    void ValidateAllFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_Individual");
        Properties propValue = readPropertiesFromFile("TC_IndividualValues");
       /* driver.findElement(By.xpath(properties.getProperty("countrydp"))).click();
        Thread.sleep(2000);*/
        driver.findElement(By.name(properties.getProperty("address"))).sendKeys(propValue.getProperty("address"));
        driver.findElement(By.name(properties.getProperty("addrs"))).sendKeys(propValue.getProperty("addrs"));
        driver.findElement(By.name(properties.getProperty("city"))).sendKeys(propValue.getProperty("city"));
        Thread.sleep(5000);
        //country dropdown
        driver.findElement(By.xpath(properties.getProperty("countrydrp"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(properties.getProperty("countrydrplist"))).click();
        Thread.sleep(2000);
        //state dropdown
        driver.findElement(By.xpath(properties.getProperty("state"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("statelist"))).click();
        Thread.sleep(2000);
        driver.findElement(By.name(properties.getProperty("postal"))).sendKeys(propValue.getProperty("postal"));
        driver.findElement(By.id(properties.getProperty("date"))).sendKeys(propValue.getProperty("date"));
        driver.findElement(By.xpath(properties.getProperty("citizen"))).click();
        driver.findElement(By.xpath(properties.getProperty("texnumber"))).click();
        driver.findElement(By.xpath(properties.getProperty("idnumber"))).click();
        driver.findElement(By.name(properties.getProperty("idcard"))).sendKeys(propValue.getProperty("idcard"));
        driver.findElement(By.xpath(properties.getProperty("createbutton"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(properties.getProperty("okbutton"))).click();
        System.out.println("individual profile successfully created");

    }
    @Test(priority =2)
    void EmptyAddresscitypostaldateidcardFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_Individual");
        Properties propValue = readPropertiesFromFile("TC_IndividualValues");
        //country dropdown
        driver.findElement(By.xpath(properties.getProperty("countrydrp"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(properties.getProperty("countrydrplist"))).click();
        Thread.sleep(2000);
        //state dropdown
        driver.findElement(By.xpath(properties.getProperty("state"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("statelist"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("citizen"))).click();
        driver.findElement(By.xpath(properties.getProperty("texnumber"))).click();
        driver.findElement(By.xpath(properties.getProperty("idnumber"))).click();
      //  driver.findElement(By.name(properties.getProperty("idcard"))).sendKeys(propValue.getProperty("idcard1"));
        driver.findElement(By.xpath(properties.getProperty("createbutton"))).click();
        System.out.println("Address fields required \n postal field required \n city field required \n Date field required \n id card field required ");
        Thread.sleep(3000);
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
