package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortProductsAToZTest {

    @Test
    public void verifySortingAToZ() throws InterruptedException {

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

        // Select A to Z sorting
        select.selectByVisibleText("Name (A to Z)");

        System.out.println("Sorting selected: Name (A to Z)");
        Thread.sleep(4000);

        // Validate first product
        WebElement firstProduct = driver.findElement(
                By.className("inventory_item_name")
        );

        String firstProductName = firstProduct.getText();
        System.out.println("First Product: " + firstProductName);

        Assert.assertEquals(
                firstProductName,
                "Sauce Labs Backpack",
                "Sorting validation failed"
        );

        System.out.println("Validation successful: Products sorted A to Z");

        Thread.sleep(5000);

        driver.quit();
    }
}