package stepdefs;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)

@CucumberOptions(
		
		monochrome= true,
		plugin={"pretty","html:target/cucumber-report","json:target/cucumber.json"},
		features = "src/test/java/features", 
		glue = "stepdefs",
		tags = {"@sanity"}
		//tags = {"not @ignore"}  // it will ignore all the @ignore scenarios and rest all will be executed
		//tags = {"@login"}  // it will run all the scenarios in login feature file
		//tags = {"@sanity or @regression"} // it will execute all the scenarios with @sanity or @regression
		//tags = {"@sanity and @regression"} // it will execute all the scenarios with @sanity and @regression both
		)

public class TestRunner {
	
	@AfterClass
    public static void setup() {
        File reportOutputDirectory = new File("target");
        List<String> jsonFiles = Arrays.asList("target/cucumber.json");
        String buildNumber = "1";
        String projectName = "cucumber-project";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;
        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Platform", "Windows");
        configuration.addClassifications("Browser", "Chrome");
        configuration.addClassifications("Branch", "release/1.0");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
    }

}
