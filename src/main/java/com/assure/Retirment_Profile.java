package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Retirment_Profile extends Joint_Profile {
    public Retirment_Profile() {

    }

    public void Retirmentprof() throws Exception {
        WebDriver driver = Config.getDriver();
        Properties properties = readPropertiesFromFile("Retirmentprofile");
        Properties propValue = readPropertiesFromFile("Retirmentprofilevalues");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         /*for(int i=0; i<=2;i++){
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
        Thread.sleep(3000);
        for(int i=0; i<=2;i++){
            try{
                driver.findElement(xpath("(//button[@type='button'])[2]")).click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }*/
        driver.findElement(By.xpath(properties.getProperty("CreateNewProfile"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retirmentbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmcountryformation"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmcountryformationdropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("RetmCitizenbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("RetmCitizenbutton2"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("RetmIdentitydocbutton"))).click();
        driver.findElement(By.xpath(properties.getProperty("RetmIdentificationtype"))).click();
        Thread.sleep(2000);
        JavascriptExecutor dbr = (JavascriptExecutor) driver;
        dbr.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("RetmNationalins"))).click();
        driver.findElement(By.xpath(properties.getProperty("RetmNationalinsfld"))).sendKeys(propValue.getProperty("RetmNationalinsfld"));
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmaddress1"))).sendKeys(propValue.getProperty("Retmaddress1"));
        driver.findElement(By.xpath(properties.getProperty("Retmaddress2"))).sendKeys(propValue.getProperty("Retmaddress2"));
        driver.findElement(By.xpath(properties.getProperty("Retmcity1"))).sendKeys(propValue.getProperty("Retmcity1"));
        driver.findElement(By.xpath(properties.getProperty("Retmcountry"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmcountrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmstate"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmstatedropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("RetmpostalCode"))).sendKeys(propValue.getProperty("RetmpostalCode"));
        driver.findElement(By.xpath(properties.getProperty("investingcheck"))).click();
        driver.findElement(By.xpath(properties.getProperty("Rtmprofilebtn"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Rtmprofileclosebtn"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmaccreditation"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("CheckBox01"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox02"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox03"))).click();
        driver.findElement(By.xpath(properties.getProperty("Retmqualifiedpurchaser"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("CheckBox04"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox05"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox06"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox07"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox08"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox09"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox10"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox11"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox12"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox13"))).click();
        driver.findElement(By.xpath(properties.getProperty("CheckBox14"))).click();
        driver.findElement(By.xpath(properties.getProperty("Retmcreateprofilebtn"))).click();
        Thread.sleep(5000);
        System.out.println("successfully Retirment profile created");

        InvestmentDeal();
    }
    public static void  InvestmentDeal()throws Exception {
        InvestmentDeal deal = new InvestmentDeal();
        deal.InvestDeal();
    }
}