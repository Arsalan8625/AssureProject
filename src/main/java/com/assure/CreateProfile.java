package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.nio.ByteBuffer;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.assure.Config.driver;

public class CreateProfile extends Login {
    public CreateProfile() {

    }

    public void NewProfile() throws Exception {
        Properties properties = readPropertiesFromFile("Profile");
        Properties propValue = readPropertiesFromFile("Profilevalues");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        /*driver.findElement(By.xpath(properties.getProperty("deal"))).click();
        Thread.sleep(5000);
        driver.findElement(By.id(properties.getProperty("createnewprofile"))).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Individual profile
        driver.findElement(By.id(properties.getProperty("individualprofile"))).click();
       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        System.out.println("successfully open profile");
        Thread.sleep(5000);
        //country dropdown
      driver.findElement(By.xpath(properties.getProperty("countrydp"))).click();
       Thread.sleep(2000);
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
        //Orginazor Entity profile
        driver.findElement(By.xpath(properties.getProperty("createnewdeal"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(properties.getProperty("createnewprofileentity"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("entitybutton"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("entitycountry"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("entitycountrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("stateofformation"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("stateofformationdropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("entityname"))).sendKeys(propValue.getProperty("entityname"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("limitedcompany"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("limitedcompanydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("address1"))).sendKeys(propValue.getProperty("address1"));
        driver.findElement(By.xpath(properties.getProperty("address2"))).sendKeys(propValue.getProperty("address2"));
        driver.findElement(By.xpath(properties.getProperty("city1"))).sendKeys(propValue.getProperty("city1"));
        Thread.sleep(1000);
        driver.findElement(By.xpath(properties.getProperty("country"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("countrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("state1"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("statelst"))).click();
        Thread.sleep(2000);
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
        driver.findElement(By.xpath(properties.getProperty("OKbutton"))).click();
        System.out.println("Entity profile successfully created");*/
        NewDeal();
     //   driver.close();
    }
    public static void  NewDeal()throws Exception {
        NewDeal deal = new NewDeal();
        deal.Deal();
    }
}
