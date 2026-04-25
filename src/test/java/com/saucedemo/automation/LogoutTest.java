package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogoutTest {

    @Test
    public void verifyLogout() throws InterruptedException {

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

        // Open menu
        driver.findElement(
                By.id("react-burger-menu-btn")
        ).click();

        System.out.println("Menu opened");
        Thread.sleep(5000);

        // Logout using JavaScriptExecutor
        WebElement logoutButton = driver.findElement(
                By.id("logout_sidebar_link")
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logoutButton);

        System.out.println("Logout clicked");
        Thread.sleep(4000);

        // Validate return to login page
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("saucedemo.com"),
                "Logout validation failed"
        );

        System.out.println("Validation successful: Logout completed");

        Thread.sleep(5000);

        driver.quit();
    }
}