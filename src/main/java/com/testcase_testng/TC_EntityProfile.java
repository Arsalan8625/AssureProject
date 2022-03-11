package com.testcase_testng;

import com.assure.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.assure.Config.driver;

public class TC_EntityProfile {
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
        Properties properties = readPropertiesFromFile("TC_Entity");
        Properties propValue = readPropertiesFromFile("TC_Entityvalues");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.xpath(properties.getProperty("deal"))).click();
        Thread.sleep(5000);
        driver.findElement(By.id(properties.getProperty("createnewprofile"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(properties.getProperty("entitybutton"))).click();
        Thread.sleep(2000);
        System.out.println("successfully open Entity Profile");
        Thread.sleep(5000);
    }
    @Test(priority =3)
    void ValidateAllFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_Entity");
        Properties propValue = readPropertiesFromFile("TC_Entityvalues");
        driver.findElement(By.xpath(properties.getProperty("entityname"))).sendKeys(propValue.getProperty("entityname"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("address1"))).sendKeys(propValue.getProperty("address1"));
        driver.findElement(By.xpath(properties.getProperty("address2"))).sendKeys(propValue.getProperty("address2"));
        driver.findElement(By.xpath(properties.getProperty("city1"))).sendKeys(propValue.getProperty("city1"));
        Thread.sleep(1000);
        /*driver.findElement(By.xpath(properties.getProperty("country"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("countrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("state1"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("statelst"))).click();
        Thread.sleep(2000);*/
        driver.findElement(By.xpath(properties.getProperty("postalcode"))).sendKeys(propValue.getProperty("postalcode"));
        driver.findElement(By.xpath(properties.getProperty("texid"))).sendKeys(propValue.getProperty("texid"));
        driver.findElement(By.xpath(properties.getProperty("firstname"))).sendKeys(propValue.getProperty("firstname"));
        driver.findElement(By.xpath(properties.getProperty("lastname"))).sendKeys(propValue.getProperty("lastname"));
        driver.findElement(By.xpath(properties.getProperty("title"))).sendKeys(propValue.getProperty("title"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("dates"))).sendKeys(propValue.getProperty("dates"));
        driver.findElement(By.xpath(properties.getProperty("citizenbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("citizenbutton2"))).click();
        Thread.sleep(2000);
        JavascriptExecutor db=(JavascriptExecutor)driver;
        db.executeScript("window.scrollBy(0,2000)","");
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("identitydocbutton"))).click();
       // driver.findElement(By.xpath(properties.getProperty("identificationtype"))).click();
        Thread.sleep(2000);
        JavascriptExecutor dbe=(JavascriptExecutor)driver;
        dbe.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(2000);
       // driver.findElement(By.xpath(properties.getProperty("nationalins"))).click();
       // clearFields();
        driver.findElement(By.xpath("//input[@name='id2']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("nationalinsfld"))).sendKeys(propValue.getProperty("nationalinsfld"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("createprofilebutton"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("OKbutton"))).click();
        System.out.println("Entity profile successfully created");
    }
    @Test(priority =2)
    void EmptyAddresscitypostaldateidcardFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_Entity");
        Properties propValue = readPropertiesFromFile("TC_Entityvalues");
        driver.findElement(By.xpath(properties.getProperty("entitycountry"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("entitycountrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("stateofformation"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("stateofformationdropdown"))).click();
        Thread.sleep(2000);
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("limitedcompany"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("limitedcompanydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("country"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("countrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("state1"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("statelst"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("citizenbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("citizenbutton2"))).click();
        Thread.sleep(2000);
        JavascriptExecutor db=(JavascriptExecutor)driver;
        db.executeScript("window.scrollBy(0,2000)","");
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("identitydocbutton"))).click();
        driver.findElement(By.xpath(properties.getProperty("identificationtype"))).click();
        Thread.sleep(2000);
        JavascriptExecutor dbe=(JavascriptExecutor)driver;
        dbe.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("nationalins"))).click();
        driver.findElement(By.xpath(properties.getProperty("nationalinsfld"))).sendKeys(propValue.getProperty("nationalinsfld"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("createprofilebutton"))).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath(properties.getProperty("OKbutton"))).click();
        System.out.println("Address Field is required \n Name Fields is required \n Postal field is required \n Title field is required \n City field is required \n Entity Name is required");

    }
    @AfterTest

    public void TearDown(){
        driver.quit();
        System.out.println("successfully browser close");
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
    private void clearFields() {
        driver.findElement(By.xpath("nationalinsfld")).clear();
      //  driver.findElement(By.name("password")).clear();
    }
}
