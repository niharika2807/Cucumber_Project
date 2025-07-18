package stepdefs;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Stepdefs {

    WebDriver driver = Hooks.driver;

    @Given("I have launched the simplilearn application")
    public void i_have_launched_the_simplilearn_application() {
        driver.get("https://www.simplilearn.com/");
    }

    @When("I click on the Login Link")
    public void i_click_on_the_Login_Link() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@title='Login' and contains(@class,'login')]")
        ));
        loginLink.click();
    }

    @When("I enter the Username {string}")
    public void i_enter_the_Username(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user_login")));
        userNameField.clear();
        userNameField.sendKeys(username);
    }

    @When("I enter the Password {string}")
    public void i_enter_the_Password(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    @When("I click on the Login button")
    public void i_click_on_the_Login_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@value='Login']")
        ));
        loginButton.click();
    }

    @Then("I should be able to see the error message {string}")
    public void i_should_be_able_to_see_the_error_message(String expectedError) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("msg_box")));
            String actualError = errorElement.getText().trim();
            Assert.assertFalse("Error message is empty.", actualError.isEmpty());
            Assert.assertEquals(expectedError, actualError);
        } catch (TimeoutException e) {
            Assert.fail("Error message did not appear within the timeout.");
        }
    }
}
