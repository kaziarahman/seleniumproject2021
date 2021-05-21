package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLaunch2 {

    public static void main(String[] args) throws InterruptedException {

        // begining
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.ebay.com");


        // inside the test


        //input[@class='gLFyf gsfi']

        // // -->always starts with double slash
        // input -->tag name
        // [@key = 'value']

        // driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium Books");
        // Thread.sleep(2000);
        // driver.findElement(By.xpath("//input[@aria-label='Google Search']")).click();

        //  driver.findElement(By.id("gh-ac")).sendKeys("Java Books");
        //  Thread.sleep(2000);
        //  driver.findElement(By.id("gh-btn")).click();


        driver.findElement(By.linkText("register")).click();
        driver.findElement(By.id("firstname")).sendKeys("kazi");


        // end
        Thread.sleep(5000);

        driver.quit();
    }

}
