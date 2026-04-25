package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortLowToHighTest {

    @Test
    public void verifyLowToHighSorting() throws InterruptedException {

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

        // Locate sort dropdown
        WebElement sortDropdown = driver.findElement(
                By.className("product_sort_container")
        );

        Select select = new Select(sortDropdown);

        // Select Low to High sorting
        select.selectByVisibleText("Price (low to high)");

        System.out.println("Sorting selected: Price (Low to High)");
        Thread.sleep(4000);

        // Validate first product price
        WebElement firstPrice = driver.findElement(
                By.className("inventory_item_price")
        );

        String actualPrice = firstPrice.getText();
        System.out.println("First Product Price: " + actualPrice);

        Assert.assertEquals(
                actualPrice,
                "$7.99",
                "Price sorting validation failed"
        );

        System.out.println("Validation successful: Price sorted Low to High");

        Thread.sleep(5000);

        driver.quit();
    }
}