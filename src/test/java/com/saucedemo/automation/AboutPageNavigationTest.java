package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AboutPageNavigationTest {

    @Test
    public void verifyAboutPageNavigation() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);

        // Login
        driver.findElement(By.id("user-name"))
                .sendKeys("standard_user");

        driver.findElement(By.id("password"))
                .sendKeys("secret_sauce");

        driver.findElement(By.id("login-button"))
                .click();

        System.out.println("Login completed");
        Thread.sleep(4000);

        // Open hamburger menu
        driver.findElement(
                By.id("react-burger-menu-btn")
        ).click();

        System.out.println("Hamburger menu opened");
        Thread.sleep(5000);

        // Click About using JavaScriptExecutor
        WebElement aboutButton = driver.findElement(
                By.id("about_sidebar_link")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", aboutButton);

        System.out.println("About clicked");
        Thread.sleep(5000);

        // Validate redirected URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("saucelabs.com"),
                "About page navigation failed"
        );

        System.out.println("Validation successful: About page opened");

        Thread.sleep(5000);

        driver.quit();
    }
}