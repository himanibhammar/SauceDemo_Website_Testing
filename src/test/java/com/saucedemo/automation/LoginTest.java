package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    @Test
    public void validLoginTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);

        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        System.out.println("Username entered");
        Thread.sleep(2000);

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        System.out.println("Password entered");
        Thread.sleep(2000);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        System.out.println("Login button clicked");
        Thread.sleep(4000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("inventory"),
                "Login failed or Products page did not open"
        );

        System.out.println("Validation successful: Login completed");

        Thread.sleep(5000);

        driver.quit();
    }
}