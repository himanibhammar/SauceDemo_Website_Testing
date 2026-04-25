package com.saucedemo.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmptyCartValidationTest {

    @Test
    public void verifyEmptyCartValidation() throws InterruptedException {

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

        // Open cart without adding products
        driver.findElement(
                By.className("shopping_cart_link")
        ).click();

        System.out.println("Cart opened");
        Thread.sleep(3000);

        // Validate cart is empty
        List<WebElement> cartItems = driver.findElements(
                By.className("cart_item")
        );

        int itemCount = cartItems.size();
        System.out.println("Items in Cart: " + itemCount);

        Assert.assertEquals(
                itemCount,
                0,
                "Cart is not empty"
        );

        System.out.println("Validation successful: Cart is empty");

        Thread.sleep(5000);

        driver.quit();
    }
}