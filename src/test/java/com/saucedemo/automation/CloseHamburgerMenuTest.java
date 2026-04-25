package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CloseHamburgerMenuTest {

    @Test
    public void verifyCloseHamburgerMenu() throws InterruptedException {

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

        // Click close button (X)
        driver.findElement(
                By.id("react-burger-cross-btn")
        ).click();

        System.out.println("Close button clicked");
        Thread.sleep(4000);

        // Validate menu is closed
        WebElement menuContainer = driver.findElement(
                By.className("bm-menu-wrap")
        );

        String styleValue = menuContainer.getAttribute("style");
        System.out.println("Menu Style: " + styleValue);

        Assert.assertTrue(
                styleValue.contains("translate3d(-100%"),
                "Hamburger menu did not close properly"
        );

        System.out.println("Validation successful: Hamburger menu closed");

        Thread.sleep(5000);

        driver.quit();
    }
}