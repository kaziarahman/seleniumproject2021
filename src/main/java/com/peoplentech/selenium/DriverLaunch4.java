package com.peoplentech.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class DriverLaunch4 {

    private static WebDriver driver;

    public static void setupBrowser(String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.get(url);
    }


    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void closeBrowser() {
        waitFor(3);
        driver.quit();
    }

    public static void clickOnLinkText(String lnkTxt) {
        driver.findElement(By.linkText(lnkTxt)).click();
    }

    public static void clickOnXpath(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    public static void typeOnXpath(String xpath, String data) {
        driver.findElement(By.xpath(xpath)).sendKeys(data);
    }


    public static void navigateBack() {
        driver.navigate().back();
    }

    public static void clickOnId(String id) {
        driver.findElement(By.id(id)).click();
    }


    @Test
    public void validateUserCanClickOnRegisterButton() {
        setupBrowser("chrome", "https://www.ebay.com");
        clickOnLinkText("register");
        navigateBack();
        closeBrowser();
    }

    @Test
    public void validateUserCanClickOnSignInButton() {
        setupBrowser("chrome", "https://www.ebay.com");
        clickOnLinkText("Sign in");
        closeBrowser();
    }

    @Test
    public void validatedUserCanSearchForItemsInAmazon() {
        setupBrowser("firefox", "https://www.amazon.com");
        typeOnXpath("//input[@id='twotabsearchtextbox']", "Java Books");
        waitFor(2);
        closeBrowser();
    }

    @Test
    public void validatedUserCanSearchForItemsInEbay() {
        setupBrowser("firefox", "https://www.ebay.com");
        waitFor(5);
        typeOnXpath("//input[@id='gh-ac']", "Java Books");
        clickOnId("gh-btn");
        closeBrowser();
    }


}
