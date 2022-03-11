package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class Joint_Profile extends Trust_Profile{
    public Joint_Profile(){

    }
    public void Jointprof() throws Exception {
        WebDriver driver = Config.getDriver();
        Properties properties = readPropertiesFromFile("Jointprofile");
        Properties propValue = readPropertiesFromFile("Jointprofilevalues");
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
        driver.findElement(xpath(properties.getProperty("createNewProfile"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointcountryformation"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointcountryformationdropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointtype"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointtypedropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("displayname"))).sendKeys(propValue.getProperty("displayname"));
        driver.findElement(xpath(properties.getProperty("jointname"))).sendKeys(propValue.getProperty("jointname"));
        driver.findElement(xpath(properties.getProperty("jointfirstName"))).sendKeys(propValue.getProperty("jointfirstName"));
        driver.findElement(xpath(properties.getProperty("jointlastName"))).sendKeys(propValue.getProperty("jointlastName"));
        driver.findElement(xpath(properties.getProperty("jointtitle"))).sendKeys(propValue.getProperty("jointtitle"));
        driver.findElement(xpath(properties.getProperty("jointDates"))).sendKeys(propValue.getProperty("jointDates"));
        driver.findElement(xpath(properties.getProperty("jointaddress1"))).sendKeys(propValue.getProperty("jointaddress1"));
        driver.findElement(xpath(properties.getProperty("jointaddress2"))).sendKeys(propValue.getProperty("jointaddress2"));
        driver.findElement(xpath(properties.getProperty("jointcity1"))).sendKeys(propValue.getProperty("jointcity1"));
        driver.findElement(xpath(properties.getProperty("jointcountry"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointcountrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointstate"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointstatedropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointpostalCode"))).sendKeys(propValue.getProperty("jointpostalCode"));
        driver.findElement(xpath(properties.getProperty("jointCitizenbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointCitizenbutton2"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointIdentitydocbutton"))).click();
        driver.findElement(xpath(properties.getProperty("jointIdentificationtype"))).click();
        Thread.sleep(2000);
        JavascriptExecutor dbjt=(JavascriptExecutor)driver;
        dbjt.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("jointNationalins"))).click();
        driver.findElement(xpath(properties.getProperty("jointNationalinsfld"))).sendKeys(propValue.getProperty("jointNationalinsfld"));
        Thread.sleep(2000);
        JavascriptExecutor dbj=(JavascriptExecutor)driver;
        dbj.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(2000);
        /* driver.findElement(xpath(properties.getProperty("jointFirstName"))).sendKeys(propValue.getProperty("jointFirstName"));
         driver.findElement(xpath(properties.getProperty("jointLastName"))).sendKeys(propValue.getProperty("jointLastName"));
         driver.findElement(xpath(properties.getProperty("jointemail"))).sendKeys(propValue.getProperty("jointemail"));
         Thread.sleep(2000);*/
        //Add Signatory form
        driver.findElement(By.xpath(properties.getProperty("addsignatorybuttonjt"))).click();
        Thread.sleep(3000);
        WebElement ele = driver.findElement(By.xpath("(//input[@name='firstName'])[2]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
        driver.findElement(By.xpath("(//input[@name='firstName'])[2]")).sendKeys("Add sign Name");
        driver.findElement(By.xpath("(//input[@name='lastName'])[2]")).sendKeys("Second Signer");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("arslan6728@gmail.com");
        //driver.findElement(By.xpath(properties.getProperty("FirstNamejt"))).sendKeys(propValue.getProperty("FirstNamejt"));
        //driver.findElement(By.xpath(properties.getProperty("LastNamejt"))).sendKeys(propValue.getProperty("LastNamejt"));
        //driver.findElement(By.xpath(properties.getProperty("emailjt"))).sendKeys(propValue.getProperty("emailjt"));
        driver.findElement(By.xpath(properties.getProperty("savebuttonjt"))).click();
        System.out.println("Successfully Add Signatory Added");
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("jointaccbtn"))).click();
        System.out.println("Joint Profile successfully created");
        driver.findElement(xpath(properties.getProperty("jointaccreditation"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("checkBox01"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox02"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox03"))).click();
        JavascriptExecutor dba=(JavascriptExecutor)driver;
        dba.executeScript("window.scrollBy(0,500)","");
        Thread.sleep(2000);
        //  driver.findElement(By.xpath(properties.getProperty("checkBox04"))).click();
        driver.findElement(xpath(properties.getProperty("qualifiedpurchaser"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("checkBox05"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox06"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox07"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox08"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox09"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox10"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox11"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox12"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox13"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox14"))).click();
        driver.findElement(xpath(properties.getProperty("checkBox15"))).click();
        driver.findElement(xpath(properties.getProperty("jointcreateprofilebtn"))).click();
        Thread.sleep(5000);
        System.out.println("successfully Joint profile created");
        Retirment_Profile();

}

    public static void  Retirment_Profile()throws Exception {
        Retirment_Profile prof = new Retirment_Profile();
        prof.Retirmentprof();
    }
}
