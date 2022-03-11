package com.assure;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.awt.*;
import java.util.Properties;

import static com.assure.Config.driver;
import static org.openqa.selenium.By.xpath;

public class Invite_Investor_yourself extends NewDeal {
    public Invite_Investor_yourself() {

    }

    public void InviteInvestor() throws Exception {
        Properties properties = readPropertiesFromFile("Invite_Investor");
        Properties propValue = readPropertiesFromFile("Invite_Investorvalues");
        // Invite investor to this deal
        driver.findElement(xpath(properties.getProperty("invitebutton"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("investortothisdeal"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath("//input[@type='text']")).sendKeys("arslan@yopmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("ar-btn-send-invite")).click();
        Thread.sleep(4000);
        driver.findElement(xpath("//p[text()='Done. View deal in dashboard']")).click();
        Thread.sleep(2000);
        System.out.println("successfully invite invertor to this deal");
        JavascriptExecutor dbiv = (JavascriptExecutor) driver;
        dbiv.executeScript("window.scrollBy(0,300)", "");
        Thread.sleep(4000);
        //Invite youself to this deal
        driver.findElement(xpath("(//button[@type='button'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("inviteyourself"))).click();
        Thread.sleep(3000);
        driver.findElement(xpath(properties.getProperty("saveok"))).click();
        Thread.sleep(2000);
        System.out.println("successfully invite yourself in deal");
        //Management Fee
        driver.findElement(xpath(properties.getProperty("managementfee"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath("(//button[@type='button'])[4]")).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("flatfee"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("flatinput"))).sendKeys(propValue.getProperty("flatinput"));
        driver.findElement(xpath(properties.getProperty("buttonsave"))).click();
        Thread.sleep(4000);
        System.out.println("successfully Added Management fee");
        //EDIT CARRY/ADD CARRY
    /* driver.findElement(xpath(properties.getProperty("carry"))).click();
     Thread.sleep(2000);
     driver.findElement(xpath("//*[@id=\"root\"]/div/div[3]/div[5]/div[1]/div[2]/div[2]/div/div/div[3]/div/div/table/tbody[2]/tr[1]/td[3]")).click();
     Thread.sleep(2000);
     driver.findElement(xpath("(//input[@name='flat'])[1]")).clear();
     Thread.sleep(2000);
     driver.findElement(xpath(properties.getProperty("flat"))).sendKeys(propValue.getProperty("flat"));
     driver.findElement(xpath(properties.getProperty("saveflat"))).click();
     Thread.sleep(2000);
     System.out.println("successfully Added carry");*/

        // Resend invitation
    /* driver.findElement(xpath(properties.getProperty("investorbtn"))).click();
     Thread.sleep(2000);
     driver.findElement(xpath(properties.getProperty("pendinginvt"))).click();
     Thread.sleep(2000);
     driver.findElement(xpath(properties.getProperty("actionbtn"))).click();
     Thread.sleep(2000);
     driver.findElement(xpath(properties.getProperty("resendinvt"))).click();
     Thread.sleep(2000);
     driver.findElement(xpath(properties.getProperty("oksave"))).click();
     Thread.sleep(2000);
     System.out.println("successfully resend invite");
        // Delete invitation
     driver.findElement(xpath(properties.getProperty("actionbtndl"))).click();
     Thread.sleep(2000);
     driver.findElement(xpath(properties.getProperty("deletebtn"))).click();
     Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("confirmbtn"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("oksavebtn"))).click();
        Thread.sleep(2000);
        driver.findElement(xpath(properties.getProperty("overview"))).click();
        Thread.sleep(2000);*/
        //investment button
        driver.findElement(By.xpath("//P[text()='Investments']")).click();
        Thread.sleep(5000);
        //Setting button
        driver.findElement(By.xpath("//P[text()='Settings']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//h5[text()='Sign out'])[2]")).click();
        System.out.println("successfully signout from organizer profile");
        Thread.sleep(5000);
         InvesterLogin();

    }
    public static void  InvesterLogin()throws Exception {
        InvesterLogin Invlgn = new InvesterLogin();
        Invlgn.InverterLoginPage();
    }
}