package com.BDD.step_Definition;

import com.BDD.pom.Pages;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class Registration extends Pages {


    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {
    }

    @When("I enter a valid email")
    public void iEnterAValidEmail() {
        registration().email.sendKeys(faker.internet().emailAddress());
    }

    @And("I click on the continue button")
    public void iClickOnTheContinueButton() {
        registration().continueButton.click();
    }


    @When("I enter firstName and password")
    public void iEnterFirstNameAndPassword() {
        registration().firstName.sendKeys(faker.name().firstName());
        registration().password.sendKeys(faker.internet().password());

    }

    @And("I  click on register button")
    public void iClickOnRegisterButton() {
        registration().registrationButton.click();
    }

    @Then("I should be on home page")
    public void iShouldBeOnHomePage() {
        homePage().maybeLater.click();
        int size = homePage().homeIconList.size();
        System.out.println("size = " + size);
        Assert.assertEquals(1,size);
    }


}
