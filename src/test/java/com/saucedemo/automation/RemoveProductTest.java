package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveProductTest {

    @Test
    public void removeProductFromCart() throws InterruptedException {

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

        // Add product first
        driver.findElement(
                By.xpath("(//button[contains(text(),'Add to cart')])[1]")
        ).click();

        System.out.println("Product added");
        Thread.sleep(2000);

        // Remove same product
        driver.findElement(
                By.xpath("(//button[contains(text(),'Remove')])[1]")
        ).click();

        System.out.println("Product removed");
        Thread.sleep(3000);

        // Validate cart badge disappears
        boolean cartBadgePresent = driver.findElements(
                By.className("shopping_cart_badge")
        ).size() > 0;

        Assert.assertFalse(
                cartBadgePresent,
                "Cart badge still present after removing product"
        );

        System.out.println("Validation successful: Product removed from cart");

        Thread.sleep(5000);

        driver.quit();
    }
}