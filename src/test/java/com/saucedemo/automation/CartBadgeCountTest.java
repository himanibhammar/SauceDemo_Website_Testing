package com.saucedemo.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CartBadgeCountTest {

    @Test
    public void verifyProductsInCart() throws InterruptedException {

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

        // Add 3 products
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
        Thread.sleep(3000);

        System.out.println("Three products added");

        // Open cart page
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(4000);

        // Validate number of products inside cart
        List<WebElement> cartItems = driver.findElements(
                By.className("cart_item")
        );

        int itemCount = cartItems.size();
        System.out.println("Items in Cart: " + itemCount);

        Assert.assertEquals(
                itemCount,
                3,
                "Cart item count validation failed"
        );

        System.out.println("Validation successful: 3 products present in cart");

        Thread.sleep(5000);

        driver.quit();
    }
}