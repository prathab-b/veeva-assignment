package stepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.java.After;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("User opens the login page")
    public void userOpensLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        loginPage = new LoginPage(driver);
    }

    @When("User enters the username {string}")
    public void userEntersUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("User enters the password {string}")
    public void userEntersPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("User clicks the submit button")
    public void userClicksSubmitButton() {
        loginPage.clickSubmit();
    }

    @Then("User should be redirected to the page containing {string}")
    public void userShouldBeRedirectedToSuccessPage(String expectedUrl) {
        assertTrue(loginPage.getCurrentURL().contains(expectedUrl));
    }

    @Then("User should see {string}")
    public void userShouldSeeSuccessMessage(String expectedMessage) {
        assertTrue(loginPage.isSuccessMessageDisplayed(expectedMessage));
    }

    @Then("User should see the Log out button")
    public void userShouldSeeLogoutButton() {
        assertTrue(loginPage.isLogoutDisplayed());
    }

    @Then("User should see the error message with text {string}")
    public void userShouldSeeErrorMessage(String expectedError) {
        assertEquals(expectedError, loginPage.getErrorMessage());
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
