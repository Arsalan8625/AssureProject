package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Properties;

import static org.openqa.selenium.By.xpath;

public class Dealclose extends InvestmentDeal {
    public Dealclose() {

    }

    public void Deal() throws Exception {
        WebDriver driver = Config.getDriver();
        Properties properties = readPropertiesFromFile("Dealclose");
        Properties propValue = readPropertiesFromFile("Dealclosevalues");
        driver.findElement(xpath(properties.getProperty("alreadyaccount"))).click();
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        driver.findElement(xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
        driver.findElement(xpath(properties.getProperty("loginButton"))).click();
        System.out.println("Successfully landed to Organizer dashboard for deal closing");
        Thread.sleep(5000);
        driver.findElement(xpath(properties.getProperty("Viewbutton"))).click();
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("invertorbutton"))).click();
        Thread.sleep(3000);
        JavascriptExecutor inv=(JavascriptExecutor)driver;
        inv.executeScript("window.scrollBy(0,800)","");
        Thread.sleep(2000);
        WebElement action=driver.findElement(By.xpath("(//td[@class='MuiTableCell-root jss658 MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[10]"));
        inv.executeScript("arguments[0].scrollIntoView();",action);
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("actionbutton"))).click();
        Thread.sleep(3000);
        //Re-generate Documents
        driver.findElement(By.xpath("//li[text()='Re-generate documents']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("5000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        Thread.sleep(2000);
        System.out.println("Successfully regenerate deal documents sent for Approval");
        //Add side letter to investors
        driver.findElement(By.xpath("(//td[@class='MuiTableCell-root jss658 MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[10]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[text()='Add Side letter for this investor']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='organizerCarryPercentage']")).sendKeys("10");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        Thread.sleep(2000);
        System.out.println("Successfully side letter added for the following investor ");
        //Add a note to this investor
        driver.findElement(By.xpath("(//td[@class='MuiTableCell-root jss658 MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[10]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//li[text()='Add a note to this investor']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Test Note");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        Thread.sleep(3000);
        //Deal close
        driver.findElement(By.xpath("(//td[@class='MuiTableCell-root jss658 MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[10]")).click();
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("markascompletebutton"))).click();
        Thread.sleep(3000);
        // Refund investment
       /* driver.findElement(By.xpath("(//td[@class='MuiTableCell-root jss658 MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeSmall'])[10]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[text()='Refund investment']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("6600");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        Thread.sleep(2000);
        System.out.println("Successfully refund investment");*/
        driver.findElement(xpath(properties.getProperty("dealclosebutton"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("skipbutton"))).click();
        Thread.sleep(1000);
        driver.findElement(xpath(properties.getProperty("addinvertortoclose"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("checkbox"))).click();
        Thread.sleep(1000);
        driver.findElement(xpath(properties.getProperty("savebutton"))).click();
        Thread.sleep(2000);
        // Add Beneficiary
      /*  driver.findElement(By.xpath("//p[text()='Add beneficiary']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Assur Glassboard");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Arslan6718@yopmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@class='PhoneInputCountrySelect']")).click();
        driver.findElement(By.xpath("//option[text()='Pakistan']")).click();
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("3225830444");
        driver.findElement(By.xpath("//input[@name='bankName']")).sendKeys("HBL");
        driver.findElement(By.xpath("//input[@name='routingNumber']")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@name='accountNumber']")).sendKeys("123456789000");
        driver.findElement(By.xpath("//input[@name='verifyAccountNumber']")).sendKeys("123456789000");
        driver.findElement(By.xpath("//input[@name='bankAddress1']")).sendKeys("Mall road");
        driver.findElement(By.xpath("//input[@name='bankAddress2']")).sendKeys("DAVIS ROAD");
        driver.findElement(By.xpath("//input[@name='bankCity']")).sendKeys("LAHORE");
        driver.findElement(By.xpath("//input[@name='country']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[text()='Pakistan']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='state']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[text()='Balochistan']")).click();
        driver.findElement(By.xpath("//input[@name='bankPostalCode']")).sendKeys("48000");
        driver.findElement(By.xpath("//input[@name='nameOnAccount']")).sendKeys("Arslan");
        driver.findElement(By.xpath("//input[@name='accountAddress1']")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='accountAddress2']")).sendKeys("Malroad");
        driver.findElement(By.xpath("//input[@name='bankAddress2']")).sendKeys("DAVIS ROAD");
        driver.findElement(By.xpath("//input[@name='accountCity']")).sendKeys("LAHORE");
        driver.findElement(By.xpath("//input[@name='country']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[text()='Pakistan']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='state']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[text()='Balochistan']")).click();
        driver.findElement(By.xpath("//input[@name='accountPostalCode']")).sendKeys("48000");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[text()='OK']")).click();
        Thread.sleep(2000);
        System.out.println("successfully add benificary account");*/
        //Delete Benificary Account
        //Edit Benificary Account
        driver.findElement(xpath(properties.getProperty("signclose"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("understandcontinue"))).click();
        Thread.sleep(2000);
        //signature close deal
        WebElement signatureCanvas = driver.findElement(xpath("//canvas[@height='221']"));
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(signatureCanvas,400,0).build().perform();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("acceptbutton"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("backtodeal"))).click();
        Thread.sleep(5000);
        System.out.println("successfully deal closed");
        driver.close();

    }
}