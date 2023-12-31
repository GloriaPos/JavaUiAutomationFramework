package com.opencart;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.managers.ScrollManager;
import com.opencart.pageobjects.AccountCreatedPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.RegisterPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = DriverManager.getInstance().getDriver();

        driver.get("https://andreisecuqa.host/");

        HomePage homePage = new HomePage(driver);
        homePage.navigateToRegisterPageFromHeaderMenu();

        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String randomEmail = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPassword(10,20);

        RegisterPage registerPage = new RegisterPage(driver);
        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password);
        registerPage.switchOnThePrivacyToggle(driver);
        registerPage.clickOnContinueButton();

        Thread.sleep(2000);
        System.out.println(driver.getCurrentUrl());

        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        accountCreatedPage.logoutFromTheAccount();

        Thread.sleep(1000);
        System.out.println(driver.getCurrentUrl());


        driver.quit();

        System.out.println("The execution was finished!");
    }
}