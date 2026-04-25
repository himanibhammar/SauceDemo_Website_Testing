package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HamburgerMenuValidationTest {

    @Test
    public void verifyHamburgerMenuOptions() throws InterruptedException {

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
        driver.findElement(By.id("react-burger-menu-btn")).click();

        System.out.println("Hamburger menu opened");
        Thread.sleep(5000);

        // Scroll inside menu for stable visibility
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        Thread.sleep(2000);

        // Locate all 4 menu options
        WebElement allItems = driver.findElement(By.id("inventory_sidebar_link"));
        WebElement about = driver.findElement(By.id("about_sidebar_link"));
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        WebElement reset = driver.findElement(By.id("reset_sidebar_link"));

        // Validate visibility
        Assert.assertTrue(allItems.isDisplayed(), "All Items is not visible");
        Assert.assertTrue(about.isDisplayed(), "About is not visible");
        Assert.assertTrue(logout.isDisplayed(), "Logout is not visible");
        Assert.assertTrue(reset.isDisplayed(), "Reset App State is not visible");

        System.out.println("Validation successful: All 4 menu options are visible");

        Thread.sleep(5000);

        driver.quit();
    }
}