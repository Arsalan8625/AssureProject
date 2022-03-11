package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class InvesterLogin extends Invite_Investor_yourself {
    public InvesterLogin() {

    }

    public void InverterLoginPage() throws Exception {
        WebDriver driver = Config.getDriver();
        Properties properties = readPropertiesFromFile("InvesterLogin");
        Properties propValue = readPropertiesFromFile("Investerloginvalues");
      //  driver.get("https://assure-staging.herokuapp.com/");
        driver.findElement(By.xpath(properties.getProperty("alreadyaccount"))).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath(properties.getProperty("email"))).sendKeys(propValue.getProperty("email"));
        driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(propValue.getProperty("password"));
        driver.findElement(By.xpath(properties.getProperty("loginButton"))).click();
        System.out.println("Successfully landed to Inverter dashboard");
        Entity_Profile();


}
    public static Properties readPropertiesFromFile(String fileName) {
        Properties ob = new Properties();
        try {
            FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\repositories\\"+fileName+".properties");
            ob.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ob;

    }
    public static void  Entity_Profile()throws Exception {
        Entity_Profile prof = new Entity_Profile();
        prof.Entityprof();
    }

}
