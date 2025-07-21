package stepdefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import base.BaseTest;
import pages.LoginPage;
import pages.InventoryPage;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;
    InventoryPage inventoryPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        setup(); // from BaseTest
        loginPage = new LoginPage(driver);
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
    }

    @When("clicks the login button")
    public void clicks_the_login_button() {
        inventoryPage = loginPage.clickLogin();
    }

    @Then("user should be navigated to the inventory page")
    public void user_should_be_navigated_to_the_inventory_page() {
        Assert.assertTrue(inventoryPage.getPageTitle().contains("Swag"));
        tearDown();
    }

    @When("user enters invalid username or password")
    public void user_enters_invalid_username_or_password() {
        loginPage.enterUsername("wrong_user");
        loginPage.enterPassword("wrong_pass");
        loginPage.clickLogin();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface"));
        tearDown();
    }
}
