package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LockedUserTest {

    @Test
    public void lockedUserValidation() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);

        // Enter locked user username
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("locked_out_user");

        System.out.println("Locked user username entered");
        Thread.sleep(2000);

        // Enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        System.out.println("Password entered");
        Thread.sleep(2000);

        // Click Login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        System.out.println("Login button clicked");
        Thread.sleep(3000);

        // Validate locked user error message
        WebElement errorMessage = driver.findElement(
                By.xpath("//*[contains(text(),'Sorry, this user has been locked out')]")
        );

        Assert.assertTrue(errorMessage.isDisplayed());

        System.out.println("Validation successful: Locked user message displayed");

        Thread.sleep(5000);

        driver.quit();
    }
}