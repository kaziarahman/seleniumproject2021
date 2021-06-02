package com.peoplentech.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class OthersTest extends TestBase {
    private static final Logger logger = Logger.getLogger(EbayTest.class);


    @Test
    public void userShouldBeAbleToPerformDragNdrop() {
        setupBrowser("chrome", "http://demo.guru99.com/test/drag_drop.html");
        logger.info("browser opened and guru99.com launched");

        WebElement source = driver.findElement(By.xpath("(//li[@id='fourth'])[1]"));
        WebElement destination = driver.findElement(By.id("amt7"));

        waitFor(2);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, destination).build().perform();

        closeBrowser();
    }

    @Test
    public void userShouldBeAbleToPerformIframes() {
        setupBrowser("chrome", "https://demoqa.com/frames");

        // 3 ways - name, id, index
        driver.switchTo().frame("frame2");
        waitFor(5);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        driver.switchTo().defaultContent();
        waitFor(5);

        js.executeScript("window.scrollBy(0,1000)");

        closeBrowser();
    }

}
