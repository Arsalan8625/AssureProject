package com.assure;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.assure.Config.driver;
import static java.time.temporal.ChronoUnit.MILLIS;
import static java.time.temporal.ChronoUnit.SECONDS;
import static org.openqa.selenium.By.*;

public class InvestmentDeal extends Retirment_Profile{

    public InvestmentDeal() {

    }

     public void InvestDeal() throws Exception {
        WebDriver driver = Config.getDriver();
        Properties properties = readPropertiesFromFile("InvestmentDeal");
        Properties propValue = readPropertiesFromFile("InvestmentDealvalues");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         //Explicit wait
       /* WebDriverWait wait=new WebDriverWait(driver,40);
        wait.until(ExpectedConditions.alertIsPresent());*/
         for(int i=0; i<=2;i++){
             try{
                 driver.findElement(xpath("(//span[text()='View Details'])[1]")).click();
                 break;
             }
             catch(Exception e){
                 System.out.println(e.getMessage());
             }
         }

       // driver.findElement(xpath(properties.getProperty("Viewdetail"))).click();
        System.out.println("View Detail button clicked");
         Thread.sleep(5000);
        JavascriptExecutor db=(JavascriptExecutor)driver;
        db.executeScript("window.scrollBy(0,800)","");
        driver.findElement(xpath(properties.getProperty("investnow"))).click();
         System.out.println("Invest now button clicked");
         //Cancel Investment button Not Intrested
     /* driver.findElement(By.xpath("(//h5[text()='Not Interested'])[1]")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//p[text()='Yes, Cancel My Investment']")).click();
      System.out.println("Successfully cancel the investment");*/
         //select profile dropdown...............................................................
         Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("dropdown"))).click();
        Thread.sleep(2000);
        /*driver.findElement(xpath(properties.getProperty("trentbutton"))).click();
        Thread.sleep(2000);*//*
         driver.findElement(xpath(properties.getProperty("indianentitybutton"))).click();
         Thread.sleep(2000);*/
         //Investment with Joint Signer
         driver.findElement(xpath(properties.getProperty("joinbutton"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("selectbutton"))).click();
         Thread.sleep(3000);
        System.out.println("successfully selected profile and landed to page");
        JavascriptExecutor doc =(JavascriptExecutor)driver;
        doc.executeScript("window.scrollBy(0,1500)","");
        driver.findElement(xpath(properties.getProperty("amount"))).sendKeys(propValue.getProperty("amount"));
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("bankName"))).sendKeys(propValue.getProperty("bankName"));
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("checkbox"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("generatedoc"))).click();
        Thread.sleep(10000);
        //signature needed
          driver.findElement(xpath(properties.getProperty("signaturetype"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("signature"))).sendKeys(propValue.getProperty("signature"));
        Thread.sleep(5000);
        System.out.println("successfully sign");
        JavascriptExecutor sig=(JavascriptExecutor)driver;
        sig.executeScript("window.scrollBy(0,800)","");
        Thread.sleep(4000);
        driver.findElement(xpath(properties.getProperty("submit"))).click();
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("funddropdown"))).click();
        Thread.sleep(2000);
        /*driver.findElement(xpath(properties.getProperty("dropdownselect"))).click();
        Thread.sleep(2000);*/
      driver.findElement(xpath(properties.getProperty("dropdownselected"))).click();
      Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("completeinvestment"))).click();
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("confirmbutton"))).click();
        System.out.println("successfully Joint signer invest in deal the amount is 100000");
        Thread.sleep(3000);
        //div scroll down
         WebElement DIVelement = driver.findElement(By.xpath("(//span[text()='Nudge'])[1]"));
         JavascriptExecutor jse = (JavascriptExecutor)driver;
         jse.executeScript("arguments[0].scrollIntoView(true)", DIVelement);
        /*JavascriptExecutor inv=(JavascriptExecutor)driver;
        inv.executeScript("window.scrollBy(0,800)","");*/
        System.out.println(" successfully page viewed");
        // Edit Investment in investment page
      driver.findElement(xpath(properties.getProperty("editinvestment"))).click();
      Thread.sleep(2000);
      driver.findElement(xpath(properties.getProperty("increaseinvst"))).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@name='amount']")).clear();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@name='amount']")).sendKeys("7500");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//input[@name='bankName']")).sendKeys("ABL");
      Thread.sleep(2000);
      driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//div[@id='mui-component-select-fund-source']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("(//li[@tabindex='0'])[2]")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
      Thread.sleep(3000);
      driver.findElement(xpath(properties.getProperty("confirmbutton"))).click();
      System.out.println("successfully increase invest in deal the amount is 7500");

        //logout from investor side
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("settings"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("signout"))).click();
         System.out.println("successfully signout from investor page");
         Thread.sleep(2000);
         //Login to Yopmail account
         driver.get("https://yopmail.com/en/");
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("login"))).sendKeys(propValue.getProperty("login"));
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("gobutton"))).click();
         Thread.sleep(5000);
      //   driver.findElement(xpath(properties.getProperty("loginbutton"))).click();
         System.out.println("successfully invite investor through Yopmail");
         Thread.sleep(2000);
         driver.get("https://assure-staging.herokuapp.com");
         Thread.sleep(2000);
         System.out.println("Landed to Signer page");
         driver.findElement(xpath(properties.getProperty("alreadyaccount"))).click();
         Thread.sleep(3000);
         driver.findElement(xpath(properties.getProperty("jtemail"))).sendKeys(propValue.getProperty("jtemail"));
         driver.findElement(xpath(properties.getProperty("jtpassword"))).sendKeys(propValue.getProperty("jtpassword"));
         driver.findElement(xpath(properties.getProperty("loginButton"))).click();
         System.out.println("successfully joint invertor page open");
         Thread.sleep(3000);
         //Joint Invertor first time signup
        /* driver.findElement(By.xpath(properties.getProperty("sigfirstname"))).sendKeys(propValue.getProperty("sigfirstname"));
         driver.findElement(By.xpath(properties.getProperty("siglastname"))).sendKeys(propValue.getProperty("siglastname"));
         driver.findElement(By.xpath(properties.getProperty("sigmobilenumbr"))).click();
         driver.findElement(By.xpath(properties.getProperty("sigcountryselect"))).click();
         driver.findElement(By.xpath(properties.getProperty("sigmobilenumber"))).sendKeys(propValue.getProperty("sigmobilenumber"));
         driver.findElement(By.xpath(properties.getProperty("sigcountry"))).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("sigcountrydropdown"))).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("sigstate"))).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("sigstatedropdown"))).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("sigDates"))).sendKeys(propValue.getProperty("sigDates"));
         driver.findElement(By.xpath(properties.getProperty("sigpostalCode"))).sendKeys(propValue.getProperty("sigpostalCode"));
         driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
         driver.findElement(By.xpath(properties.getProperty("sigbutton"))).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath(properties.getProperty("agreebutton"))).click();
         Thread.sleep(5000);*/
         //Joint Singer details page
         driver.findElement(xpath(properties.getProperty("jtDates"))).sendKeys(propValue.getProperty("jtDates"));
         driver.findElement(xpath(properties.getProperty("ssnumber"))).sendKeys(propValue.getProperty("ssnumber"));
         driver.findElement(xpath(properties.getProperty("jtaddress1"))).sendKeys(propValue.getProperty("jtaddress1"));
         driver.findElement(xpath(properties.getProperty("jtaddress2"))).sendKeys(propValue.getProperty("jtaddress2"));
         driver.findElement(xpath(properties.getProperty("jtcity1"))).sendKeys(propValue.getProperty("jtcity1"));
         driver.findElement(xpath(properties.getProperty("jtcountry"))).click();
         Thread.sleep(3000);
         driver.findElement(xpath(properties.getProperty("jtcountrydropdown"))).click();
         Thread.sleep(3000);
         driver.findElement(xpath(properties.getProperty("jtstate"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("jtstatedropdown"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("jtpostalCode"))).sendKeys(propValue.getProperty("jtpostalCode"));
         driver.findElement(xpath(properties.getProperty("buttonsave"))).click();
         Thread.sleep(5000);
         System.out.println("successfully save investor Info");
         JavascriptExecutor jt =(JavascriptExecutor)driver;
         jt.executeScript("window.scrollBy(0,1500)","");
         driver.findElement(xpath(properties.getProperty("jtsignaturetype"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("jtsignature"))).sendKeys(propValue.getProperty("jtsignature"));
         driver.findElement(xpath(properties.getProperty("acceptsignbutton"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("jtsettings"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("jtsignout"))).click();
         System.out.println("successfully signout from investor page");
         Thread.sleep(2000);
         Dealclose();
      //driver.close();

    }
 public static void  Dealclose()throws Exception {
  Dealclose deal = new Dealclose();
  deal.Deal();
 }

}
