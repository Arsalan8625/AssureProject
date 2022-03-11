package com.testcase_testng;

import com.assure.Config;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Properties;

import static org.openqa.selenium.By.xpath;


public class TC_NewDeal {
    WebDriver driver = Config.getDriver();
    private WebDriverWait wait;

    @BeforeTest
    void OpenBrowser() throws InterruptedException {
        driver.get("https://assure-staging.herokuapp.com/");
        driver.manage().window().maximize();
        System.out.println("Successfully landed to login page");
        Thread.sleep(2000);
        Properties properties = readPropertiesFromFile("TC_login");
        Properties propValue = readPropertiesFromFile("TC_loginvalues");
        driver.get("https://assure-staging.herokuapp.com/");
        driver.findElement(By.xpath(properties.getProperty("alreadyaccount"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
        driver.findElement(By.xpath(properties.getProperty("loginButton"))).click();
        System.out.println("Successfully landed to dashboard");
        Thread.sleep(2000);
    }

    @Test(priority = 1)
    void OpenProfile() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_NewDeal");
        Properties propValue = readPropertiesFromFile("TC_NewDealvalues");
        wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
        driver.findElement(By.xpath(properties.getProperty("deal"))).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath(properties.getProperty("profiledropdown"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(properties.getProperty("selectprofile"))).click();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)","");
        Thread.sleep(2000);
        //For Assure Labs button
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("ar-btn-enter-deal-details")).click();
        Thread.sleep(2000);
        System.out.println("successfully Landed to Enter Deal Detail For Assure Lab");
        Thread.sleep(5000);
    }
     @Test(enabled = false,priority =2)
         // for skip
  //  @Test(priority = 2)
    void AssureLabDealAllFields() throws InterruptedException, AWTException {
        Properties properties = readPropertiesFromFile("TC_NewDeal");
        Properties propValue = readPropertiesFromFile("TC_NewDealvalues");
        Robot robot=new Robot();
        Thread.sleep(3000);
        //Verify Deal title
        WebElement titlevalidate=driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[1]/div[2]/h6"));
        if(titlevalidate.isDisplayed())
        {
            System.out.println("Assure Lab Deal Title is Displayed");
        }
        else {
            System.out.println("Title is not Displayed");
        }
        //Validation the actual and expected text
        String expectedText="Fund 0060 a series of Assure Labs GB 2022, LLC";
        String actualText=titlevalidate.getText();
        //compare the actual and expected text
        if(actualText.equals(expectedText))
        {
            System.out.println("actual and expected title are same"+ actualText);
        }
          else {
            System.out.println("actual and expected title are not same"+ actualText);
        }

        driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[1]/div[1]/input")).sendKeys("Assure lab DEAL PROCESS P2");
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
        Thread.sleep(3000);
        driver.findElement(By.name("targetRaiseAmount")).sendKeys("50000");
        Thread.sleep(2000);
        driver.findElement(By.name("minInvestmentAmount")).sendKeys("5500");
        Thread.sleep(2000);
        driver.findElement(By.name("organizerCarryPercentage")).sendKeys("10");
        Thread.sleep(2000);
        driver.findElement(By.name("estimatedCloseDate")).sendKeys("05282022");
        Thread.sleep(2000);
        driver.findElement(By.id("ar-btn-generate-doc")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath(properties.getProperty("okbutton"))).click();
        System.out.println("Assure Labs Deal successfully created.");
        Thread.sleep(10000);
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
        System.out.println("successfully landed Dashboard to view the Created Assure lab deal");
        JavascriptExecutor db=(JavascriptExecutor)driver;
        db.executeScript("window.scrollBy(0,300)","");
        Thread.sleep(5000);

    }
    @Test(priority =3)
    void ValidateEmptyfieldAssureLab() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_NewDeal");
        Properties propValue = readPropertiesFromFile("TC_NewDealvalues");
        try
        {
            driver.findElement(By.xpath("//*[@id=\"ar-new-deal-button\"]")).click();
        }  catch (Exception e)

        {
            System.out.println("Element not find");
            e.printStackTrace();
        }

        Thread.sleep(5000);
        try
        {
            driver.findElement(By.xpath(properties.getProperty("profiledropdown"))).click();
        }  catch (Exception e)

        {
            System.out.println("Element not find");
            e.printStackTrace();
        }
       // driver.findElement(By.xpath(properties.getProperty("profiledropdown"))).click();
        driver.findElement(By.xpath("(//li[text()='Arslan - INDIVIDUAL'])[3]")).click();
        //Assure Lab deal
        driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("ar-btn-enter-deal-details")).click();
        Thread.sleep(2000);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,1000)","");
        driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[1]/div[1]/input")).sendKeys("Assure lab p3");
        Thread.sleep(3000);
        driver.findElement(By.name("targetRaiseAmount")).sendKeys("50000");
        Thread.sleep(2000);
        driver.findElement(By.name("minInvestmentAmount")).sendKeys("5500");
        Thread.sleep(2000);
        driver.findElement(By.name("organizerCarryPercentage")).sendKeys("10");
        Thread.sleep(2000);
        driver.findElement(By.name("estimatedCloseDate")).sendKeys("05282023");
        Thread.sleep(2000);
        driver.findElement(By.id("ar-btn-generate-doc")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath(properties.getProperty("okbutton"))).click();
        System.out.println("Assure Labs Deal successfully created without \n Deal description\n Deal Logo\n Management fee.");

    }
    @Test(priority =4)
    void StandardLabAllFields() throws InterruptedException, AWTException {
        Properties properties = readPropertiesFromFile("TC_NewDeal");
        Properties propValue = readPropertiesFromFile("TC_NewDealvalues");
        Robot robot=new Robot();
        driver.findElement(By.xpath("//p[text()='Deals']")).click();
        Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,-500)","");
        for(int i=0; i<=2;i++){
            try{
                driver.findElement(xpath("//button[@id='ar-new-deal-button']")).click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
      //  driver.findElement(By.xpath("//button[@id='ar-new-deal-button']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@id='mui-component-select-profile']")).click();
        driver.findElement(By.xpath(properties.getProperty("selectprofile"))).click();
        //Standard Lab deal=
        driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("ar-btn-enter-deal-details")).click();
        Thread.sleep(2000);
        //Verify Deal title
        WebElement titlevalidate=driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[1]/div[2]/h6"));
        if(titlevalidate.isDisplayed())
        {
            System.out.println("Assure Lab Deal Title is Displayed");
        }
        else {
            System.out.println("Title is not Displayed");
        }
        //Validation the actual and expected text
        String expectedText="Fund 0027 a series of Assure Standard Master GB 2022, LLC";
        String actualText=titlevalidate.getText();
        //compare the actual and expected text
        if(actualText.equals(expectedText))
        {
            System.out.println("actual and expected title are same"+ actualText);
        }
        else {
            System.out.println("actual and expected title are not same"+ actualText);
        }
        driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[1]/div[1]/input")).sendKeys("Standard p4 DEAL PROCESS");
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
        Thread.sleep(3000);
        driver.findElement(By.name("targetRaiseAmount")).sendKeys("50000");
        Thread.sleep(2000);
        driver.findElement(By.name("minInvestmentAmount")).sendKeys("5500");
        Thread.sleep(2000);
        driver.findElement(By.name("organizerCarryPercentage")).sendKeys("10");
        Thread.sleep(2000);
        driver.findElement(By.name("estimatedCloseDate")).sendKeys("05282023");
        Thread.sleep(2000);
        driver.findElement(By.id("ar-btn-generate-doc")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath(properties.getProperty("okbutton"))).click();
        System.out.println("Standard Labs Deal successfully created");
        Thread.sleep(10000);
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
        try
        {
            driver.findElement(By.xpath("//p[text()='Done. View deal in dashboard']")).click();
        }  catch (Exception e)
        {
            System.out.println("Element not find");
            e.printStackTrace();
        }
        Thread.sleep(2000);
        System.out.println("successfully landed Dashboard to view the Created Standard lab deal");
        JavascriptExecutor db=(JavascriptExecutor)driver;
        db.executeScript("window.scrollBy(0,-300)","");
        Thread.sleep(5000);
    }
    @Test(priority =5)
    void StandardLab506bdeals() throws InterruptedException {
        Properties properties = readPropertiesFromFile("TC_NewDeal");
        Properties propValue = readPropertiesFromFile("TC_NewDealvalues");
        Thread.sleep(3000);
        for(int i=0; i<=2;i++){
            try{
                driver.findElement(xpath("//button[@id='ar-new-deal-button']")).click();
                break;
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
       /* driver.findElement(By.xpath("//*[@id=\"ar-new-deal-button\"]")).click();
        Thread.sleep(5000);*/
        //*[@id="ar-new-deal-button"]
        try
        {
            driver.findElement(By.xpath("//*[@id=\"mui-component-select-profile\"]")).click();
        }  catch (Exception e)
        {
            System.out.println("Element not find");
            e.printStackTrace();
        }

        try
        {
            driver.findElement(By.xpath(properties.getProperty("selectprofile"))).click();
        }  catch (Exception e)
        {
            System.out.println("Element not find");
            e.printStackTrace();
        }

        //Standard Lab deal
        try
        {
            driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        }  catch (Exception e)
        {
            System.out.println("Element not find");
            e.printStackTrace();
        }
       // driver.findElement(By.xpath("(//button[@type='button'])[5]")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("ar-btn-enter-deal-details")).click();
        Thread.sleep(2000);
        //Verify Deal title
        WebElement titlevalidate=driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[1]/div[2]/h6"));
        if(titlevalidate.isDisplayed())
        {
            System.out.println("Assure Lab Deal Title is Displayed");
        }
        else {
            System.out.println("Title is not Displayed");
        }
        //Validation the actual and expected text
        String expectedText="Fund 0029 a series of Assure Standard Master GB 2022, LLC";
        String actualText=titlevalidate.getText();
        //compare the actual and expected text
        if(actualText.equals(expectedText))
        {
            System.out.println("actual and expected title are same"+ actualText);
        }
        else {
            System.out.println("actual and expected title are not same"+ actualText);
        }
        driver.findElement(By.xpath("//*[@id=\"flow-container\"]/div[3]/form/div[1]/div[1]/input")).sendKeys("Standard P5 DEAL PROCESS");
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[3]/form/div[2]/div[2]/div/div/div[2]/div/div[2]/div")).sendKeys("Purchase Real Estate to Operate Your Business On.\n To get an EB-5  $900,000) in a US business.");
        System.out.println("successfully write the deal description");
        Thread.sleep(3000);
        driver.findElement(By.name("targetRaiseAmount")).sendKeys("500000");
        Thread.sleep(2000);
        driver.findElement(By.name("minInvestmentAmount")).sendKeys("5500");
        Thread.sleep(2000);
        driver.findElement(By.name("organizerCarryPercentage")).sendKeys("11");
        Thread.sleep(2000);
        driver.findElement(By.name("estimatedCloseDate")).sendKeys("05282024");
        Thread.sleep(2000);
        //deal 506 (b)
        driver.findElement(By.xpath("//input[@name='offering-type' and @value='b']")).click();
        //Management fee
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        driver.findElement(By.xpath("//input[@name='type' and @value='flat fee']")).click();
        driver.findElement(By.name("flat fee")).sendKeys("1500");
        Thread.sleep(2000);
        driver.findElement(By.id("ar-btn-generate-doc")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath(properties.getProperty("okbutton"))).click();
        System.out.println("Standard Labs 506(b) Deal successfully created");
        Thread.sleep(10000);
        JavascriptExecutor je=(JavascriptExecutor)driver;
        je.executeScript("window.scrollBy(0,1500)","");
        Thread.sleep(20000);
        driver.findElement(By.id("ar-check-reveiew-acceptance")).click();
        driver.findElement(By.id("ar-btn-approve-continue")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div/p/div/div[4]/div/input")).sendKeys("invsal@yopmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("ar-btn-send-invite")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//p[text()='Done. View deal in dashboard']")).click();
        Thread.sleep(2000);
        System.out.println("successfully landed Dashboard to view the Created Standard lab 506(b) deal");
        JavascriptExecutor db=(JavascriptExecutor)driver;
        db.executeScript("window.scrollBy(0,300)","");
        Thread.sleep(5000);

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
