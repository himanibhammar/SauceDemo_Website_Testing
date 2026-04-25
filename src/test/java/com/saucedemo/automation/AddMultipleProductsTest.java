package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddMultipleProductsTest {

    @Test
    public void addMultipleProductsToCart() throws InterruptedException {

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
        Thread.sleep(3000);

        // First Product - Backpack
        WebElement firstProduct = driver.findElement(
                By.id("add-to-cart-sauce-labs-backpack")
        );
        firstProduct.click();

        System.out.println("First product added");
        Thread.sleep(3000);

        // Second Product - Bike Light
        WebElement secondProduct = driver.findElement(
                By.id("add-to-cart-sauce-labs-bike-light")
        );
        secondProduct.click();

        System.out.println("Second product added");
        Thread.sleep(5000);

        // Validate cart badge
        WebElement cartBadge = driver.findElement(
                By.className("shopping_cart_badge")
        );

        String badgeCount = cartBadge.getText();
        System.out.println("Cart Badge Count: " + badgeCount);

        Assert.assertEquals(
                badgeCount,
                "2",
                "Multiple product cart validation failed"
        );

        System.out.println("Validation successful: Multiple products added");

        Thread.sleep(5000);

        driver.quit();
    }
}