package com.peoplentech.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class EbayTestOld extends TestBaseOld {
    private static final Logger logger = Logger.getLogger(EbayTestOld.class);


    @Test
    public void validatedUserCanSearchForItemsInEbay() {
        setupBrowser("chrome", "https://www.ebay.com");
        logger.info("browser opened and ebay.com launched");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.ebay.com/";
        Assert.assertEquals(actualUrl, expectedUrl, "url didn't match");
        logger.info("ebay homepage url has validated");


        WebElement ebayLogo = driver.findElement(By.id("gh-l-h1"));
        Assert.assertTrue(ebayLogo.isDisplayed(), "result is not true");
        logger.info("ebay logo has been displayed");


        waitFor(5);

        typeOnXpath("//input[@id='gh-ac']", "Java Books");
        logger.info("typed java books in the search bar");


        clickOnId("gh-btn");
        logger.info("search button has been clicked");


        WebElement result = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        String log = result.getText();
        Assert.assertTrue(log.contains("Java Books"), "log didn't contain Java Books");
        logger.info(log + " : has been displayed");


        closeBrowser();
    }


    @Test
    public void validateUserBeingAbleToChooseOptionFromSearchDropDown() {
        setupBrowser("chrome", "https://www.ebay.com");
        logger.info("browser opened and ebay.com launched");

        WebElement categoryDropdown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropdown);
        select.selectByVisibleText("Art");

        closeBrowser();
    }


    @Test
    public void validateUserBeingAbleToHandleDropDownOptions() {
        setupBrowser("chrome", "https://www.ebay.com");

        List<WebElement> dropdownList = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));


        System.out.println(dropdownList.size());

        for (WebElement webElement : dropdownList) {
            System.out.println(webElement.getText());
            // System.out.println(dropdownList.get(i).getAttribute("value"));
        }

        closeBrowser();
    }


    @Test
    public void validateUserBeingAbleToChooseOptionFromMouseHover() {
        setupBrowser("chrome", "https://www.ebay.com");

        WebElement motors = driver.findElement(By.linkText("Motors"));
        Actions actions = new Actions(driver);
        actions.moveToElement(motors).build().perform();
        driver.findElement(By.linkText("Classics")).click();

        closeBrowser();
    }


    @Test
    public void userShouldBeAbleToScrollDown() {
        setupBrowser("chrome", "https://www.ebay.com");

        waitFor(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        waitFor(2);

        closeBrowser();
    }


    @Test
    public void userShouldBeAbleToScrollDownToElement() {
        setupBrowser("chrome", "https://www.ebay.com");
        logger.info("browser opened and ebay.com launched");

        WebElement element = driver.findElement(By.linkText("About eBay"));

        waitFor(2);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        waitFor(2);

        closeBrowser();
    }
}
// HW :
// develop 10 use case test scenario
// in those tests make sure to use at least 50+ different locator (xpath, id) try to ignore using class name
// use logger.info
// use validation after every actions