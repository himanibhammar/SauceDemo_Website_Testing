package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductPageTitleTest {

    @Test
    public void verifyProductPageTitle() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);

        // Login with valid credentials
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        System.out.println("Login completed");
        Thread.sleep(3000);

        // Verify Products title
        WebElement pageTitle = driver.findElement(
                By.className("title")
        );

        String actualTitle = pageTitle.getText();
        System.out.println("Page Title: " + actualTitle);

        Assert.assertEquals(
                actualTitle,
                "Products",
                "Products page title validation failed"
        );

        System.out.println("Validation successful: Products page opened");

        Thread.sleep(5000);

        driver.quit();
    }
}