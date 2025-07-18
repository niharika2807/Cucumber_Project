package stepdefs;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	public static WebDriver driver;

	@Before
	public void SetUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@After
	public void TearDown(Scenario scenario) {

		if (scenario.isFailed()) {

			TakesScreenshot ts = (TakesScreenshot) driver;

			byte[] src = ts.getScreenshotAs(OutputType.BYTES);
			scenario.embed(src, "image/png", "screenshot");
		}
		driver.quit();
	}

}
