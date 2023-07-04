package com.opencart.stepdefinitions;

import com.opencart.managers.DataFakerManager;
import com.opencart.managers.DriverManager;
import com.opencart.pageobjects.RegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class RegisterPageSteps {

    WebDriver driver = DriverManager.getInstance().getDriver();
    RegisterPage registerPage = new RegisterPage(driver);

    @When("the registration form is completed with valid random data")
    public void theRegistrationFormIsCompletedWithValidRandomData() {
        String firstName = DataFakerManager.getRandomName();
        String lastName = DataFakerManager.getRandomName();
        String randomEmail = DataFakerManager.getRandomEmail();
        String password = DataFakerManager.getRandomPassword(10, 20);

        registerPage.fillInTheRegisterForm(firstName, lastName, randomEmail, password);
        
    }

    @And("the privacyToggle is enabled")
    public void thePrivacyToggleIsEnabled() {
        try {
            registerPage.switchOnThePrivacyToggle(driver);
        } catch (InterruptedException e) {
            System.out.println("Error!");
        }

    }

    @And("continueButton is clicked")
    public void continuebuttonIsClicked() throws InterruptedException {
        registerPage.clickOnContinueButton();
        Thread.sleep(500);
    }

    @And("the registration form is completed with the following data:")
    public void theRegistrationFormIsCompletedWithTheFollowingData(Map<String, String> userdetailsMap) {
        String firstNameValue = userdetailsMap.get("firstName");
        if (firstNameValue != null && firstNameValue.toUpperCase().equals("RANDOM")) {
            firstNameValue = DataFakerManager.getRandomName();
        }

        String lastNameValue = userdetailsMap.get("lastName");
        if (lastNameValue !=null && lastNameValue.toUpperCase().equals("RANDOM")) {
            lastNameValue = DataFakerManager.getRandomName();
        }

        String emailValue = userdetailsMap.get("email");
        if (emailValue !=null && emailValue.toUpperCase().equals("RANDOM")) {
            emailValue = DataFakerManager.getRandomEmail();
        }

        String passwordValue = userdetailsMap.get("password");
        if (passwordValue !=null && passwordValue.toUpperCase().equals("RANDOM")) {
            passwordValue = DataFakerManager.getRandomPassword(6,12);
        }

        registerPage.fillInTheRegisterForm(firstNameValue, lastNameValue, emailValue, passwordValue);

    }
}
