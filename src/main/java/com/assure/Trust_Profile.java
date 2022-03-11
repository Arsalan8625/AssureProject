package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class Trust_Profile extends Entity_Profile{
    public Trust_Profile(){

    }
    public void Trustprof() throws Exception {
        WebDriver driver = Config.getDriver();
        Properties properties = readPropertiesFromFile("Trustprofile");
        Properties propValue = readPropertiesFromFile("Trustprofilevalues");
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
        driver.findElement(By.xpath(properties.getProperty("createnewProfile"))).click();
        //Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Trustbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Trustcountryformation"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Trustcountryformationdropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Textid"))).sendKeys(propValue.getProperty("Textid"));
        driver.findElement(By.xpath(properties.getProperty("Trustaccount"))).sendKeys(propValue.getProperty("Trustaccount"));
        driver.findElement(By.xpath(properties.getProperty("Trustaddress1"))).sendKeys(propValue.getProperty("Trustaddress1"));
        driver.findElement(By.xpath(properties.getProperty("Trustaddress2"))).sendKeys(propValue.getProperty("Trustaddress2"));
        driver.findElement(By.xpath(properties.getProperty("Trustcity1"))).sendKeys(propValue.getProperty("Trustcity1"));
        driver.findElement(By.xpath(properties.getProperty("Trustcountry"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Trustcountrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Truststate"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Truststatedropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("postalCode"))).sendKeys(propValue.getProperty("postalCode"));
        driver.findElement(By.xpath(properties.getProperty("firstName"))).sendKeys(propValue.getProperty("firstName"));
        driver.findElement(By.xpath(properties.getProperty("lastName"))).sendKeys(propValue.getProperty("lastName"));
        driver.findElement(By.xpath(properties.getProperty("Trusttitle"))).sendKeys(propValue.getProperty("Trusttitle"));
        driver.findElement(By.xpath(properties.getProperty("Dates"))).sendKeys(propValue.getProperty("Dates"));
        driver.findElement(By.xpath(properties.getProperty("Citizenbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Citizenbutton2"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Identitydocbutton"))).click();
        driver.findElement(By.xpath(properties.getProperty("Identificationtype"))).click();
        Thread.sleep(2000);
        JavascriptExecutor dbt=(JavascriptExecutor)driver;
        dbt.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Nationalins"))).click();
        driver.findElement(By.xpath(properties.getProperty("Nationalinsfld"))).sendKeys(propValue.getProperty("Nationalinsfld"));
        Thread.sleep(2000);
        //Add Signatory form on Trust page............
        driver.findElement(By.xpath(properties.getProperty("addsignatorybutton"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(properties.getProperty("FirstName"))).sendKeys(propValue.getProperty("FirstName"));
        driver.findElement(By.xpath(properties.getProperty("LastName"))).sendKeys(propValue.getProperty("LastName"));
        driver.findElement(By.xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        /* driver.findElement(By.xpath(properties.getProperty("addtitle"))).sendKeys(propValue.getProperty("addtitle"));
         driver.findElement(By.xpath(properties.getProperty("addDates"))).sendKeys(propValue.getProperty("addDates"));
         driver.findElement(By.xpath(properties.getProperty("addCitizenbutton"))).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("addCitizenbutton2"))).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("addIdentitydocbutton"))).click();
         driver.findElement(By.xpath(properties.getProperty("addIdentificationtype"))).click();
         Thread.sleep(2000);
         JavascriptExecutor dbad=(JavascriptExecutor)driver;
         dbad.executeScript("window.scrollBy(0,500)","");
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("addNationalins"))).click();
         driver.findElement(By.xpath(properties.getProperty("addNationalinsfld"))).sendKeys(propValue.getProperty("addNationalinsfld"));
         Thread.sleep(2000);*/
         /*Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("savebutton"))).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath(properties.getProperty("trustaccredbutton"))).click();
         Thread.sleep(3000);
         driver.findElement(By.xpath(properties.getProperty("Trustaccreditation"))).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("checkbox01"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox02"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox03"))).click();
         driver.findElement(By.xpath(properties.getProperty("QualifiedPurchaser"))).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("checkbox04"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox05"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox06"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox07"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox08"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox09"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox10"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox11"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox12"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox13"))).click();
         driver.findElement(By.xpath(properties.getProperty("checkbox14"))).click();
         driver.findElement(By.xpath(properties.getProperty("createprofilebtn"))).click();
         Thread.sleep(5000);
          System.out.println("successfully Trust profile created");*/
          Joint_Profile();
    }
    public static void  Joint_Profile()throws Exception {
        Joint_Profile prof = new Joint_Profile();
        prof.Jointprof();
    }

}
