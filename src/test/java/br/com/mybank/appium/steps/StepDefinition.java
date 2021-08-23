package br.com.mybank.appium.steps;

import br.com.mybank.appium.helper.PropertiesReaderBuilder;
import br.com.mybank.appium.pageobject.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.*;

public class StepDefinition {

    private Home home = new Home();

    @Given("^I'm at mybank home$")
    public void homeMyBank() {
        home.validateHome();

    }


    @And("^select the remember option$")
    public void validateOptionRemember() {

        home.selectRememberButton();
    }

    @And("^does not inform user data$")
    public void notInputLoginData() {

        home.notInputLogin();
    }

    @And("^inform the user's data usuario com dados$")
    public void inputLoginData() {
        home.inputLogin();
    }


    @Then("^displays incorrect login and password data$")
    public void incorrectData() {
        home.validateElementsOnScreen();
    }

    @Then("^user logs into the system$")
    public void systemLogin() {
        
    }
}
