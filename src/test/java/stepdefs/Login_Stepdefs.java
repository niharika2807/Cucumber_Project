package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Login_Stepdefs {

	WebDriver driver = Hooks.driver;

	@Given("I have launched the simplilearn application")
	public void i_have_launched_the_simplilearn_application() {
		// Write code here that turns the phrase above into concrete actions

		driver.get("https://simplilearn.com/");
	}

	@When("I click on the Login Link")
	public void i_click_on_the_Login_Link() {
		// Write code here that turns the phrase above into concrete actions
		WebElement LoginLink = driver.findElement(By.linkText("Login"));
		LoginLink.click();
	}

	@When("I enter the Username")
	public void i_enter_the_Username() {
		// Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys("abc@xyz.com");
	}

	@When("I enter the Password")
	public void i_enter_the_Password() {
		// Write code here that turns the phrase above into concrete actions
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys("Abcf@1234");
	}

	@When("I click on the Login button")
	public void i_click_on_the_Login_button() {
		// Write code here that turns the phrase above into concrete actions
		WebElement LoginBtn = driver.findElement(By.name("btnlogin"));
		LoginBtn.click();
	}

	@Then("I should be able to see the home page")
	public void i_should_be_able_to_see_the_home_page() {
		// Write code here that turns the phrase above into concrete actions

	}

	@When("I enter the Username {string}")
	public void i_enter_the_Username(String UserNameVal) {
		// Write code here that turns the phrase above into concrete actions
		WebElement UserName = driver.findElement(By.name("user_login"));
		UserName.sendKeys(UserNameVal);
	}

	@When("I enter the Password {string}")
	public void i_enter_the_Password(String PasswordVal) {
		// Write code here that turns the phrase above into concrete actions
		WebElement Password = driver.findElement(By.id("password"));
		Password.sendKeys(PasswordVal);
	}

	@Then("I should be able to see the error message {string}")
	public void i_should_be_able_to_see_the_error_message(String expError) {
	    WebElement errorElement = null;
	    try {
	        errorElement = driver.findElement(By.id("msg_box"));
	    } catch (Exception e) {
	        Assert.fail("Error message element with id 'msg_box' not found.");
	    }

	    String actError = errorElement.getText().trim();
	    Assert.assertFalse("Error message is empty.", actError.isEmpty());
	    Assert.assertEquals(expError, actError);
	}


}

