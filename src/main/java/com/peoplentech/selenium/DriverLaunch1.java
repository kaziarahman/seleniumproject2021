package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverLaunch1 {

    public static void main(String[] args) throws InterruptedException {

        // setup the environment property
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");

        // created object of chromedriver
        WebDriver driver = new ChromeDriver();
        // interface object = new constructor of the chromedriver class

        // open the browser
        driver.get("https://www.google.com");

        // type for selenium books
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Selenium Books");

        // wait
        Thread.sleep(2000);

        // click on search button
        driver.findElement(By.xpath("//input[@aria-label='Google Search']")).click();


        // wait
        Thread.sleep(2000);

        // quit the browser
        driver.quit();

    }
}
