package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddSingleProductTest {

    @Test
    public void addSingleProductToCart() throws InterruptedException {

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

        // Add first product to cart
        WebElement addToCartButton = driver.findElement(
                By.xpath("(//button[contains(text(),'Add to cart')])[1]")
        );

        addToCartButton.click();

        System.out.println("Product added to cart");
        Thread.sleep(3000);

        // Validate cart badge count
        WebElement cartBadge = driver.findElement(
                By.className("shopping_cart_badge")
        );

        String badgeCount = cartBadge.getText();
        System.out.println("Cart Badge Count: " + badgeCount);

        Assert.assertEquals(
                badgeCount,
                "1",
                "Cart badge count validation failed"
        );

        System.out.println("Validation successful: Product added to cart");

        Thread.sleep(5000);

        driver.quit();
    }
}