package stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/main/java/Features"}
, glue = "stepdefinitions", plugin = {"pretty", "html:target/report.html"}
, name = "Title+")
public class TestRunner {

}
