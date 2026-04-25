package com.saucedemo.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmptyUsernameTest {

    @Test
    public void emptyUsernameValidation() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Open website
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(3000);

        // Leave username empty

        // Enter password only
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        System.out.println("Password entered");
        Thread.sleep(2000);

        // Click Login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        System.out.println("Login button clicked");
        Thread.sleep(3000);

        // Validate error message
        WebElement errorMessage = driver.findElement(
                By.xpath("//*[contains(text(),'Username is required')]")
        );

        Assert.assertTrue(errorMessage.isDisplayed());
        System.out.println(errorMessage);

        System.out.println("Validation successful: Username required message displayed");

        Thread.sleep(5000);

        driver.quit();
    }
}