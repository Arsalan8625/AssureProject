package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class Entity_Profile extends InvesterLogin {
    public Entity_Profile() {

    }

    public void Entityprof() throws Exception {
        WebDriver driver = Config.getDriver();
        Properties properties = readPropertiesFromFile("Entityprofile");
        Properties propValue = readPropertiesFromFile("Entityprofilevalues");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
        // Entity profile ALL PROFILES COMMENTED
        driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("Entity"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("countryformation"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("countryformationdropdown"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("stateofformation"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("stateofformationdropdown"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("entityname"))).sendKeys(propValue.getProperty("entityname"));
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("entitytype"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("entitytypedropdown"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("address1"))).sendKeys(propValue.getProperty("address1"));
         driver.findElement(xpath(properties.getProperty("address2"))).sendKeys(propValue.getProperty("address2"));
         driver.findElement(xpath(properties.getProperty("city1"))).sendKeys(propValue.getProperty("city1"));
         driver.findElement(xpath(properties.getProperty("country"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("countrydropdown"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("state1"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("statelst"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("postalcode"))).sendKeys(propValue.getProperty("postalcode"));
         driver.findElement(xpath(properties.getProperty("texid"))).sendKeys(propValue.getProperty("texid"));
         //driver.findElement(By.xpath(properties.getProperty("checkBox"))).click();
         Thread.sleep(2000);
         driver.findElement(By.xpath(properties.getProperty("Addsigantory"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("firstname"))).sendKeys(propValue.getProperty("firstname"));
         driver.findElement(xpath(properties.getProperty("lastname"))).sendKeys(propValue.getProperty("lastname"));
         driver.findElement(xpath(properties.getProperty("title"))).sendKeys(propValue.getProperty("title"));
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("signatoryAddress1"))).sendKeys(propValue.getProperty("signatoryAddress1"));
         driver.findElement(xpath(properties.getProperty("signatoryAddress2"))).sendKeys(propValue.getProperty("signatoryAddress2"));
         driver.findElement(xpath(properties.getProperty("signatoryCity"))).sendKeys(propValue.getProperty("signatoryCity"));
         driver.findElement(xpath(properties.getProperty("signatoryCountry"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("signatoryCountrydropdown"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("signatoryState"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("signatoryStatedropdown"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("signatoryPostalCode"))).sendKeys(propValue.getProperty("signatoryPostalCode"));
         driver.findElement(xpath(properties.getProperty("dates"))).sendKeys(propValue.getProperty("dates"));
         driver.findElement(xpath(properties.getProperty("citizenbutton"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("citizenbutton2"))).click();
         Thread.sleep(2000);
         JavascriptExecutor dbd=(JavascriptExecutor)driver;
         dbd.executeScript("window.scrollBy(0,500)","");
         Thread.sleep(3000);
         driver.findElement(xpath(properties.getProperty("identitydocbutton"))).click();
         driver.findElement(xpath(properties.getProperty("identificationtype"))).click();
         Thread.sleep(2000);
         JavascriptExecutor dbs=(JavascriptExecutor)driver;
         dbs.executeScript("window.scrollBy(0,500)","");
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("nationalins"))).click();
         driver.findElement(xpath(properties.getProperty("nationalinsfld"))).sendKeys(propValue.getProperty("nationalinsfld"));
         Thread.sleep(2000);
          driver.findElement(xpath(properties.getProperty("documenttype"))).click();
         driver.findElement(xpath(properties.getProperty("documentselect"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("savebutton"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("EntityAccreditation"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("checkbox1"))).click();
         driver.findElement(xpath(properties.getProperty("checkbox2"))).click();
         driver.findElement(xpath(properties.getProperty("checkbox3"))).click();
         driver.findElement(xpath(properties.getProperty("checkbox4"))).click();
         driver.findElement(xpath(properties.getProperty("checkbox5"))).click();
         driver.findElement(xpath(properties.getProperty("checkbox6"))).click();
         driver.findElement(xpath(properties.getProperty("checkbox7"))).click();
         Thread.sleep(2000);
         driver.findElement(xpath(properties.getProperty("createprofile"))).click();
         Thread.sleep(3000);
         System.out.println("Successfully Entity Investor profile created");
         Trust_Profile();
    }
 public static void  Trust_Profile()throws Exception {
  Trust_Profile prof = new Trust_Profile();
  prof.Trustprof();
 }
    }
