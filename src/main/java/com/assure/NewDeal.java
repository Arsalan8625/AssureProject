package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static com.assure.Config.driver;
import static org.openqa.selenium.By.xpath;

public class NewDeal extends CreateProfile {
    public NewDeal() {

    }

    public void Deal() throws Exception {
        Properties properties = readPropertiesFromFile("Deal");
        Properties propValue = readPropertiesFromFile("Dealvalues");
        Robot robot=new Robot();
      /*  driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.findElement(By.id("basic-button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[8]/div[3]/ul/li[2]/h5")).click();
        System.out.println("successfully landed to profile page");
        Thread.sleep(7000);*/
       driver.findElement(By.xpath(properties.getProperty("deal"))).click();
        System.out.println("successfully click");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@role='button']")).click();
       // driver.findElement(By.xpath(properties.getProperty("dropdownprofile"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//li[text()='Arslan - INDIVIDUAL'])[1]")).click();
        Thread.sleep(3000);
        System.out.println("profile selected");
        //Scroll web page
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)","");
        Thread.sleep(2000);
        //For Assure Labs button
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        Thread.sleep(3000);
        //For Standard Assure Deal button
      /* driver.findElement(By.id("ar-btn-select-standard")).click();*/
        //Enter Deal
        driver.findElement(By.id("ar-btn-enter-deal-details")).click();
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[1]/div[1]/input")).sendKeys("NEW DEAL PROCESS");
       Thread.sleep(3000);
       driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[2]/div/div/div[2]/div/div[2]/div")).sendKeys("Purchase Real Estate to Operate Your Business On.\n To get an EB-5  $900,000) in a US business.");
       System.out.println("successfully write the deal description");
        Thread.sleep(3000);
       //capture image by robot class
        driver.findElement(By.xpath("//*[@id=\"dropzone\"]/div/div/p/div/div/p")).click();
        Thread.sleep(3000);
        StringSelection stringSelection=new StringSelection("C:\\Users\\I_Eng\\Pictures\\image3");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,null);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        //invester details
        Thread.sleep(3000);
      /* driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[4]/label/span[1]/span[1]/input")).click();
       Thread.sleep(2000);*/
       driver.findElement(By.name("targetRaiseAmount")).sendKeys("50000");
        Thread.sleep(2000);
        driver.findElement(By.name("minInvestmentAmount")).sendKeys("5500");
        Thread.sleep(2000);
        driver.findElement(By.name("organizerCarryPercentage")).sendKeys("10");
        Thread.sleep(2000);
        driver.findElement(By.name("estimatedCloseDate")).sendKeys("05282022");
        Thread.sleep(2000);
        //button for 506(c)
      /*  driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[7]/div[1]/div[2]/div/div[2]/label/span[1]/span[1]/input")).click();
        Thread.sleep(2000);*/
        driver.findElement(By.id("ar-btn-generate-doc")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath(properties.getProperty("okbutton"))).click();
        System.out.println("Assure Labs Deal successfully created.");
        Thread.sleep(5000);
        JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("window.scrollBy(0,1500)","");
       Thread.sleep(20000);
     driver.findElement(By.id("ar-check-reveiew-acceptance")).click();
        driver.findElement(By.id("ar-btn-approve-continue")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/p/div/div[4]/div/input")).sendKeys("invsal@yopmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("ar-btn-send-invite")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//p[text()='Done. View deal in dashboard']")).click();
        Thread.sleep(2000);
        /*driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/p/div/div[4]/div/button")).click();
        Thread.sleep(5000);*/
        System.out.println("successfully landed to Dashboard to view the Created deal");
        JavascriptExecutor db=(JavascriptExecutor)driver;
        db.executeScript("window.scrollBy(0,300)","");
        Thread.sleep(5000);
        //Upload deal documents
       /* driver.findElement(By.xpath("(//p[text()='Docs'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//p[text()='Uploads'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//p[text()='Drop your file here, or']")).click();
        Thread.sleep(2000);
        StringSelection stringSelection1=new StringSelection("C:\\Users\\I_Eng\\Videos\\EDIT DEAL PROCESS - Operating Agreement.pdf");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection1,null);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        driver.findElement(By.xpath("(//button[@type='button'])[3]")).click();
        Thread.sleep(2000);
        System.out.println("Successfully upload deal documents");*/
        //Edit Deal
      /*  driver.findElement(xpath(properties.getProperty("dledbutton"))).click();Thread.sleep(3000);
     WebElement element=driver.findElement(By.xpath("//input[@name='targetRaiseAmount']"));
       element.sendKeys("5000");
       Actions a =new Actions(driver);
       a.moveToElement(element).keyDown(Keys.CONTROL).sendKeys("a",Keys.BACK_SPACE).perform();
        driver.findElement(xpath("//input[@name='targetRaiseAmount']")).clear();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("raiseamount"))).sendKeys(propValue.getProperty("raiseamount"));
        driver.findElement(xpath("//input[@name='minInvestmentAmount']")).clear();
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("mininvestment"))).sendKeys(propValue.getProperty("mininvestment"));
        driver.findElement(xpath("//input[@name='estimatedCloseDate']")).clear();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("closedate"))).sendKeys(propValue.getProperty("closedate"));
        driver.findElement(xpath(properties.getProperty("cancel"))).click();
        System.out.println("Successfully Edit Deal");*/
        //Thread.sleep(2000);
        Invite_Investor_yourself();

    }

 public static void  Invite_Investor_yourself()throws Exception {
  Invite_Investor_yourself Invyour = new Invite_Investor_yourself();
  Invyour.InviteInvestor();
 }
}