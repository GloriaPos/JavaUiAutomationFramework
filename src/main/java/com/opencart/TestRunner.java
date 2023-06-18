package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        //DriverManager driverManager = DriverManager.getInstance();
        //WebDriver driver2 = driverManager.getDriver();

        // Define a driver object that will be used for future action
        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://www.google.md/");

        String currentWindowName = driver.getWindowHandle();

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://andreisecuqa.host/");

//        WebElement accountIcon = driver.findElement(By.xpath("//i[@class='fa-solid fa-user']"));
//        accountIcon.click();
//
//        WebElement registerButton = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
//        registerButton.click();
//
//        WebElement firstNameInput = driver.findElement(By.id("input-firstname"));
//        firstNameInput.sendKeys("Anton");
//
//        WebElement lastNameInput = driver.findElement(By.id("input-lastname"));
//        lastNameInput.sendKeys("Gaidulean");
//
//        WebElement emailInput = driver.findElement(By.id("input-email"));
//        emailInput.sendKeys("a.g000011@gmail.com");
//
//        WebElement passwordInput = driver.findElement(By.id("input-password"));
//        passwordInput.sendKeys("Antonel000011!");
//
//        Thread.sleep(500);
//
//        WebElement privacyToggle = driver.findElement(By.cssSelector("input[value='1'][name='agree']"));
//        ScrollManager.scrollToElement(driver,privacyToggle);
//
//        privacyToggle.click();
//
//        WebElement continueButton = driver.findElement(By.xpath("//button[normalize-space()='Continue']"));
//        continueButton.click();
//
//        Thread.sleep(500);
//        System.out.println(driver.getCurrentUrl());


//   1st method - comment registration code lines (26 - 55) and 65-80 lines. Modify line 98
        WebElement myAccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
        myAccount.click();

        WebElement login = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Login']"));
        login.click();

//   2nd method - comment lines 62-63; uncomment registration code lines (26-55) and 67 -76  lines. Modify line 98

//        WebElement logout = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Logout']"));
//        logout.click();
//
//        Thread.sleep(1000);

//        myAccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
//        myAccount.click();
//
//        WebElement myAccountLogin = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Login']"));
//        myAccountLogin.click();

//   3rd method - comment lines 62-63 and 72-76;  uncomment registration code lines (26-55) and 79-80 lines. Modify line 98
//        WebElement login1 = driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Login']"));
//        login1.click();

        WebElement loginEmail = driver.findElement(By.xpath("//input[@id='input-email']"));
        loginEmail.sendKeys("a.g000011@gmail.com");

        WebElement loginPassword = driver.findElement(By.xpath("//input[@id='input-password']"));
        loginPassword.sendKeys("Antonel000011!");

        Thread.sleep(1000);

        WebElement loginConfirmation = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
        loginConfirmation.click();

        Thread.sleep(500);

        myAccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
        myAccount.click();

        WebElement logout = driver.findElement(By.xpath("//a[@class='dropdown-item'][normalize-space()='Logout']"));
        logout.click();

        driver.close();

        driver.switchTo().window(currentWindowName);
        Thread.sleep(1000);

        driver.get("https://www.google.md/");

        driver.quit();

        System.out.println("The execution was finished!");
    }
}