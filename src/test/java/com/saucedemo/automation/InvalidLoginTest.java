package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InvalidLoginTest {

    @Test
    public void invalidLoginTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);

        // Wrong username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("wrong_user");

        System.out.println("Invalid username entered");
        Thread.sleep(2000);

        // Wrong password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("wrong_password");

        System.out.println("Invalid password entered");
        Thread.sleep(2000);

        // Click Login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        System.out.println("Login button clicked");
        Thread.sleep(3000);

        // Validate error message
        WebElement errorMessage = driver.findElement(
                By.xpath("//*[contains(text(),'Username and password do not match')]")
        );

        Assert.assertTrue(errorMessage.isDisplayed());

        System.out.println("Validation successful: Error message displayed");

        Thread.sleep(5000);

        driver.quit();
    }
}