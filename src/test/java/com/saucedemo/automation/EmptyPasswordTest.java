package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmptyPasswordTest {

    @Test
    public void emptyPasswordValidation() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);

        // Enter username only
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        System.out.println("Username entered");
        Thread.sleep(2000);

        // Leave password empty

        // Click Login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        System.out.println("Login button clicked");
        Thread.sleep(3000);

        // Validate error message
        WebElement errorMessage = driver.findElement(
                By.xpath("//*[contains(text(),'Password is required')]")
        );

        Assert.assertTrue(errorMessage.isDisplayed());

        System.out.println("Validation successful: Password required message displayed");

        Thread.sleep(5000);

        driver.quit();
    }
}