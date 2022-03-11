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

public class TC_InvestorJointProfile {
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
        Properties properties = readPropertiesFromFile("TC_InvestorJointProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorJointProfilevalues");
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
        driver.findElements(xpath("(//h5[text()='Invest now'])[1]")).size();
        System.out.println("Invest now button displayed");
        Thread.sleep(2000);
        driver.findElement(xpath("(//h5[text()='Invest now'])[1]")).click();
        System.out.println("Invest now button clicked");
        driver.findElement(xpath("(//button[@type='button'])[2]")).isDisplayed();
        System.out.println(" create profile  button displayed");
        driver.findElement(xpath("(//button[@type='button'])[2]")).click();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.findElement(xpath(properties.getProperty("jointbutton"))).click();
        Thread.sleep(2000);

    }
    @Test(priority = 3)
    void ValidateJointProfile() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorJointProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorJointProfilevalues");
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.findElement(By.xpath("(//input[@name='citizen'])[1]")).click();
        driver.findElement(By.xpath("(//input[@name='ssnNumber'])[1]")).sendKeys("135-64-6355");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
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

    @Test(priority = 4)
    void ValidateAddSignatoryProfile() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorJointProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorJointProfilevalues");
        driver.findElement(By.xpath("(//input[@name='citizen'])[1]")).click();
        driver.findElement(By.xpath("(//input[@name='ssnNumber'])[1]")).sendKeys("135-64-6355");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
        driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
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
    void ValidateUSCitizenJointProfile() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorJointProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorJointProfilevalues");
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
        driver.findElement(By.xpath("(//input[@name='citizen'])[1]")).click();
        driver.findElement(By.xpath("(//input[@name='ssnNumber'])[1]")).sendKeys("135-64-6355");
        Thread.sleep(2000);
        //Add signatory button
        driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
        driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Johns test case");
        driver.findElement(By.xpath("(//input[@name='lastName'])[2]")).sendKeys("Add John as signar");
        driver.findElement(By.xpath("(//input[@name='email'])[3]")).sendKeys("john@6718@gmail.com");
        driver.findElement(By.xpath("(//button[@type='submit'])[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        System.out.println("US cIZITEN Profile created successfully");

    }
    @Test(priority = 6)
    void JointProfileAllFields() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_InvestorJointProfile");
        Properties propValue = readPropertiesFromFile("TC_InvestorJointProfilevalues");
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
        //Add Signatory form
        driver.findElement(By.xpath(properties.getProperty("addsignatorybuttonjt"))).click();
        Thread.sleep(3000);
        WebElement ele = driver.findElement(By.xpath("(//input[@name='firstName'])[2]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ele);
        driver.findElement(By.xpath("(//input[@name='firstName'])[2]")).sendKeys("Add sign Name");
        driver.findElement(By.xpath("(//input[@name='lastName'])[2]")).sendKeys("Second Signer");
        driver.findElement(By.xpath("(//input[@name='email'])[2]")).sendKeys("arslan6728@gmail.com");
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
