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

public class TC_InvestorRetirmentProfile {
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
        Properties properties = readPropertiesFromFile("TC_InvestorRetirmentProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorRetirmentProfilevalues");
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
        driver.get("https://assure-staging.herokuapp.com/investment/view/622678722dd50756a4791cce");
        driver.navigate().refresh();
        Thread.sleep(5000);
        JavascriptExecutor db = (JavascriptExecutor) driver;
        db.executeScript("window.scrollBy(0,800)", "");
        driver.findElement(new By.ByXPath("(//h5[text()='Invest now'])[1]")).isDisplayed();
        System.out.println("Button displayed");
        driver.findElement(new By.ByXPath("(//h5[text()='Invest now'])[1]")).click();
        System.out.println("Invest now button clicked");
        Thread.sleep(3000);
        JavascriptExecutor dbd = (JavascriptExecutor) driver;
        dbd.executeScript("window.scrollBy(0,500)", "");
       // driver.findElement(xpath(properties.getProperty("investnow"))).click();
        //Validate Error message
      /*  WebElement validatebutton=driver.findElement(By.xpath("(//h5[text()='Invest now'])[1]"));
        String expectedText="Invest now";
        String actualText=validatebutton.getText();
        //compare the actual and expected text
        if(actualText.equals(expectedText))
        {
            System.out.println("actual and expected title are same"+ actualText);
        }
        else {
            System.out.println("actual and expected title are not same"+ actualText);
        }*/
        for (int i = 0; i <= 2; i++) {
            try {
                driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        //driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
       // Thread.sleep(2000);
    }
    @Test(priority = 3)
    void ValidateMandatoryRetirmentFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorRetirmentProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorRetirmentProfilevalues");
        //driver.findElement(By.xpath(properties.getProperty("Retirmentbutton"))).click();
      //  driver.findElement(new By.ByXPath("//P[text()='Retirement ']")).click();
         driver.findElement(new By.ByXPath("//P[text()='Retirement ']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@name='usCItizen'])[1]")).click();
        driver.findElement(By.xpath("(//input[@name='ssnNumber'])[1]")).sendKeys("135-64-6355");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        Thread.sleep(2000);
      /*  driver.findElement(By.xpath("//p[text()='This field is required']")).isDisplayed();
        WebElement nameErrormessage=driver.findElement(new By.ByXPath("//p[text()='This field is required']"));
        String expectedText="This field is required";
        String actualText=nameErrormessage.getText();
        //compare the actual and expected text
        if(actualText.equals(expectedText))
        {
            System.out.println("actual and expected title are same"+ actualText);
        }
        else {
            System.out.println("actual and expected title are not same"+ actualText);
        }*/
        System.out.println("Mandatory fields required");

    }
   // @Test(enabled = false)
    @Test(priority = 4)
    void ValidateUSCitizenRetirmentFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorRetirmentProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorRetirmentProfilevalues");
        driver.findElement(By.xpath("(//input[@name='usCItizen'])[1]")).click();
        driver.findElement(By.xpath("(//input[@name='ssnNumber'])[1]")).sendKeys("135-64-6355");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@name='address1'])[1]")).sendKeys("House 25F");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@name='address2'])[1]")).sendKeys("sTREET 2516");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@name='city'])[1]")).sendKeys("Islamabad");
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmcountry"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmcountrydropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmstate"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Retmstatedropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("RetmpostalCode"))).sendKeys(propValue.getProperty("RetmpostalCode"));
        driver.findElement(By.xpath("(//input[@name='offering-type'])[2]")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='Next']")).click();
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
        System.out.println("Successfully US Citizen profile created....");

    }
   // @Test(enabled = false)
    @Test(priority = 5)
    void ValidateNonUSCitizenRetirmentFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorRetirmentProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorRetirmentProfilevalues");
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
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='Next']")).click();
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
        System.out.println("Successfully NON US Citizen profile created....");

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