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

public class TC_InvestorTrustProfile {
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
        Properties properties = readPropertiesFromFile("TC_InvestorTrustProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorTrustProfilevalues");
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
    @Test(priority = 4)
    void ValidateAllTrustFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorTrustProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorTrustProfilevalues");
        for (int i = 0; i <= 2; i++) {
            try {
                driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

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
        driver.findElement(By.xpath("//div[@id='mui-component-select-documentType']")).click();
        driver.findElement(By.xpath("//li[text()='Passport']")).click();
        Thread.sleep(2000);
        //Add Additional Signatory form
        driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
        driver.findElement(xpath("(//input[@name='firstName'])[2]")).sendKeys("Edan");
        driver.findElement(xpath("(//input[@name='lastName'])[2]")).sendKeys("John");
        driver.findElement(xpath("(//input[@name='email'])[2]")).sendKeys("ali6718@yahoo.com");
        driver.findElement(xpath("(//button[@type='button'])[2]")).click();
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
        System.out.println("successfully ValidateAllTrustFields");

}
    @Test(priority = 3)
    void ValidateAllMandatoryChecks() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorTrustProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorTrustProfilevalues");
       /* for (int i = 0; i <= 2; i++) {
            try {
                driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }*/
        driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
        driver.findElement(By.xpath(properties.getProperty("Trustbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath("(//input[@name='citizen'])[1]")).click();
        driver.findElement(xpath("//input[@name='ssnNumber']")).sendKeys("13516535");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        Thread.sleep(3000);
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
    @Test(priority = 5)
    void ValidateUnderSSNTrustFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorTrustProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorTrustProfilevalues");
        for (int i = 0; i <= 2; i++) {
            try {
                driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        driver.findElement(By.xpath(properties.getProperty("Trustbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Trustcountryformation"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Trustcountryformationdropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("Textid"))).sendKeys(propValue.getProperty("Textid"));
        driver.findElement(xpath("(//input[@name='ssnChecked']")).click();
        driver.findElement(By.xpath(properties.getProperty("firstName"))).sendKeys(propValue.getProperty("firstName"));
        driver.findElement(By.xpath(properties.getProperty("lastName"))).sendKeys(propValue.getProperty("lastName"));
        driver.findElement(xpath("//input[@name='ssnNumberChecked']")).sendKeys("65956533");
        driver.findElement(xpath("//input[@name='name']")).sendKeys("Trust");
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
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        System.out.println("Successfully Validated UnderSSNTrustFields");


    }
    @Test(priority = 6)
    void ValidateUSCitizenTrustFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorTrustProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorTrustProfilevalues");
        for (int i = 0; i <= 2; i++) {
            try {
                driver.findElement(xpath(properties.getProperty("createnewprofile"))).click();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

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
        driver.findElement(By.xpath("(//input[@name='citizen'])[1]")).click();
        driver.findElement(By.xpath("(//input[@name='ssnNumber'])[1]")).sendKeys("135-64-6355");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        System.out.println("US Citizen profile created");

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
