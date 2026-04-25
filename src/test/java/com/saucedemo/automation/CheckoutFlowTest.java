package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckoutFlowTest {

    @Test
    public void completeCheckoutFlow() throws InterruptedException {

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

        // Add product
        driver.findElement(
                By.id("add-to-cart-sauce-labs-backpack")
        ).click();

        System.out.println("Product added to cart");
        Thread.sleep(3000);

        // Open cart
        driver.findElement(
                By.className("shopping_cart_link")
        ).click();

        System.out.println("Cart opened");
        Thread.sleep(3000);

        // Checkout
        driver.findElement(
                By.id("checkout")
        ).click();

        System.out.println("Checkout started");
        Thread.sleep(3000);

        // Enter checkout details
        driver.findElement(By.id("first-name"))
                .sendKeys("Himani");

        driver.findElement(By.id("last-name"))
                .sendKeys("Bhammar");

        driver.findElement(By.id("postal-code"))
                .sendKeys("600001");

        System.out.println("User details entered");
        Thread.sleep(3000);

        // Continue
        driver.findElement(
                By.id("continue")
        ).click();

        System.out.println("Checkout continued");
        Thread.sleep(3000);

        // Finish order
        driver.findElement(
                By.id("finish")
        ).click();

        System.out.println("Order finished");
        Thread.sleep(4000);

        // Validate success message
        WebElement successMessage = driver.findElement(
                By.className("complete-header")
        );

        String actualMessage = successMessage.getText();
        System.out.println("Success Message: " + actualMessage);

        Assert.assertEquals(
                actualMessage,
                "Thank you for your order!",
                "Checkout validation failed"
        );

        System.out.println("Validation successful: Order completed");

        Thread.sleep(5000);

        driver.quit();
    }
}