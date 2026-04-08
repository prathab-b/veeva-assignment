package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * This class contains all the components and
 * actions for the login page
 */

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Login elements
    @FindBy(id = "username")
    private WebElement usernameField;
    
    @FindBy(id = "password")
    private WebElement passwordField;
    
    @FindBy(id = "submit")
    private WebElement submitButton;

    // Result elements
    @FindBy(id = "error")
    private WebElement errorMessage;

    @FindBy(linkText = "Log out")
    private WebElement logoutButton;

    // Actions
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.clear();
        usernameField.sendKeys(username);
    }
    
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();
    }

    // Getters
    public String getErrorMessage() {
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    // Validations
    public boolean isLogoutDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton));
        return logoutButton.isDisplayed();
    }

    public boolean isSuccessMessageDisplayed(String message) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));
        String pageText = driver.findElement(By.tagName("body")).getText();
        return pageText.contains(message);
    }
}