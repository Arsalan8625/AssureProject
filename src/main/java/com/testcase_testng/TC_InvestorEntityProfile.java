package com.testcase_testng;

import com.assure.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.xpath;

public class TC_InvestorEntityProfile {
    WebDriver driver = Config.getDriver();

    @BeforeTest
    void OpenBrowser() throws InterruptedException {
        driver.get("https://assure-staging.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Successfully landed to login page");
        Thread.sleep(2000);
    }

    @Test(priority = 1)
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

    @Test(priority = 2)
    void OpenProfile() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorEntityProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorEntityProfilevalues");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        for (int i = 0; i <= 2; i++) {
            try {
                driver.findElement(xpath("(//span[text()='View Details'])[1]")).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("View Detail button clicked");
        Thread.sleep(5000);
        JavascriptExecutor db = (JavascriptExecutor) driver;
        db.executeScript("window.scrollBy(0,800)", "");
        driver.findElement(xpath(properties.getProperty("investnow"))).click();
        System.out.println("Invest now button clicked");

    }

    @Test(priority = 3)
    void ValidateAllEntityFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorEntityProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorEntityProfilevalues");
        for(int i=0; i<=2;i++){
            try{
                driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
     //   driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
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
        System.out.println("Entity profile Executed / pass");
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
        System.out.println("Entity Authorized signer for this entity profile Executed / pass");
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
        System.out.println("Successfully Executed Test Entity Investor profile");

    }
    @Test(priority = 4)
    void ValidateWithoutMandatoryFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorEntityProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorEntityProfilevalues");
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
        driver.findElement(xpath(properties.getProperty("country"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("countrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("state1"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("statelst"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("checkbox"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("createprofile"))).click();
        //Validate Error message
        WebElement nameErrormessage=driver.findElement(By.xpath("//p[text()='City is required Field']"));
        String expectedText="City is required Field";
        String actualText=nameErrormessage.getText();
        //compare the actual and expected text
        if(actualText.equals(expectedText))
        {
            System.out.println("actual and expected title are same"+ actualText);
        }
        else {
            System.out.println("actual and expected title are not same"+ actualText);
        }
        System.out.println("Mandatory fields required");

}
    @Test(priority = 6)
    void ValidateAddSignatoryFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorEntityProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorEntityProfilevalues");
        driver.findElement(xpath(properties.getProperty("checkbox"))).click();
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
        JavascriptExecutor dbd = (JavascriptExecutor) driver;
        dbd.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("identitydocbutton"))).click();
        driver.findElement(xpath(properties.getProperty("identificationtype"))).click();
        Thread.sleep(2000);
        JavascriptExecutor dbs = (JavascriptExecutor) driver;
        dbs.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("nationalins"))).click();
        driver.findElement(xpath(properties.getProperty("nationalinsfld"))).sendKeys(propValue.getProperty("nationalinsfld"));
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("documenttype"))).click();
        driver.findElement(xpath(properties.getProperty("documentselect"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("savebutton"))).click();
        Thread.sleep(2000);
        System.out.println("Successfully save values for Add signatory");
    }
    @Test(priority = 5)
    void ValidateAddSignatoryMandatoryFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorEntityProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorEntityProfilevalues");
        driver.findElement(xpath(properties.getProperty("checkbox"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Addsigantory"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("firstname"))).sendKeys(propValue.getProperty("firstname"));
        driver.findElement(xpath(properties.getProperty("lastname"))).sendKeys(propValue.getProperty("lastname"));
        driver.findElement(xpath(properties.getProperty("title"))).sendKeys(propValue.getProperty("title"));
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("signatoryCountry"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("signatoryCountrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("signatoryState"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("signatoryStatedropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("citizenbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("citizenbutton2"))).click();
        Thread.sleep(2000);
        JavascriptExecutor dbd = (JavascriptExecutor) driver;
        dbd.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("identitydocbutton"))).click();
        driver.findElement(xpath(properties.getProperty("identificationtype"))).click();
        Thread.sleep(2000);
        JavascriptExecutor dbs = (JavascriptExecutor) driver;
        dbs.executeScript("window.scrollBy(0,500)", "");
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("documenttype"))).click();
        driver.findElement(xpath(properties.getProperty("documentselect"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("savebutton"))).click();
        Thread.sleep(2000);
        System.out.println("Successfully save values for Add signatory");
        //Validate Error message
        WebElement nameErrormessage=driver.findElement(By.xpath("//p[text()='This field is required']"));
        String expectedText="This field is required";
        String actualText=nameErrormessage.getText();
        //compare the actual and expected text
        if(actualText.equals(expectedText))
        {
            System.out.println("actual and expected title are same"+ actualText);
        }
        else {
            System.out.println("actual and expected title are not same"+ actualText);
        }
        System.out.println("Mandatory fields required");
    }
    @Test(priority = 7)
    void ValidateUSCitizen() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorEntityProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorEntityProfilevalues");
        for(int i=0; i<=2;i++){
            try{
                driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //   driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("Entity"))).click();
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
        //US CITIZEN
        driver.findElement(xpath("(//input[@name='citizen'])[1]")).click();
        driver.findElement(xpath("(//input[@name='ssnNumber'])[1]")).sendKeys("6856384868");
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("savebutton"))).click();
        Thread.sleep(2000);
        System.out.println("Successfully save values for US CITIZEN Add signatory");

    }
    @Test(priority = 8)
    void AddPartnerEntityFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorEntityProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorEntityProfilevalues");
        driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("Entity"))).click();
        Thread.sleep(2000);
        //Add Partner form
        driver.findElement(xpath("(//button[@type='button'])[8]")).click();
        driver.findElement(xpath("(//input[@name='citizen'])[1]")).click();
        driver.findElement(xpath("(//button[@type='button'])[2]")).click();
        //Validate Error message
        WebElement nameErrormessage=driver.findElement(By.xpath("//p[text()='This field is required']"));
        String expectedText="This field is required";
        String actualText=nameErrormessage.getText();
        //compare the actual and expected text
        if(actualText.equals(expectedText))
        {
            System.out.println("actual and expected title are same"+ actualText);
        }
        else {
            System.out.println("actual and expected title are not same"+ actualText);
        }
        System.out.println("Mandatory fields required");

    }

    @Test(priority = 9)
    void ValidateAddPartnerEntityFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorEntityProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorEntityProfilevalues");
        driver.findElement(xpath("//input[@name='firstName']")).sendKeys("Edan");
        driver.findElement(xpath("//input[@name='lastName']")).sendKeys("John");
        driver.findElement(xpath("(//input[@name='email'])[2]")).sendKeys("ali6718@yahoo.com");
        driver.findElement(xpath("//input[@name='title']")).sendKeys("Add Partner US");
        driver.findElement(xpath("//input[@name='dateOfBirth']")).sendKeys("11201999");
        driver.findElement(xpath("(//input[@name='citizen'])[1]")).click();
        driver.findElement(xpath("//input[@name='ssnNumber']")).sendKeys("6856384868");
        driver.findElement(xpath("(//button[@type='button'])[2]")).click();
        System.out.println("Partner Added successfully");


    }
    @Test(priority = 10)
    void ValidateEntityProfileWithAddPartner() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorEntityProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorEntityProfilevalues");
        for(int i=0; i<=2;i++){
            try{
                driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        //   driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
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
        System.out.println("Entity profile Executed / pass");
        //Add partner button
        driver.findElement(xpath("(//button[@type='button'])[8]")).click();
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@name='firstName']")).sendKeys("Edan");
        driver.findElement(xpath("//input[@name='lastName']")).sendKeys("John");
        driver.findElement(xpath("(//input[@name='email'])[2]")).sendKeys("ali6718@yahoo.com");
        driver.findElement(xpath("//input[@name='title']")).sendKeys("Add Partner US");
        driver.findElement(xpath("//input[@name='dateOfBirth']")).sendKeys("11201999");
        driver.findElement(xpath("(//input[@name='citizen'])[1]")).click();
        driver.findElement(xpath("//input[@name='ssnNumber']")).sendKeys("6856384868");
        driver.findElement(xpath("(//button[@type='button'])[2]")).click();
        System.out.println("Partner Added successfully");
        driver.findElement(xpath("(//button[@type='submit'])[2]")).click();
        System.out.println("successfully ValidateEntityProfileWithAddPartner");
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

}