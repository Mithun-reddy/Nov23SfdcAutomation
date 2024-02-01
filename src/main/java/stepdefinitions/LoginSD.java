package stepdefinitions;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.LoginPage;
import tests.BaseTest;
import utils.FileUtils;

public class LoginSD {
	LoginPage lp= null;
	
	@Before("@login")
	public void setup() {
		System.out.println("All your setup goes here");
	}
	
	@After("@login")
	public void tearDown() {
		System.out.println("Teardown steps goes here");
	}
	
	@Before("@regression")
	public void setup1() {
		System.out.println("All your setup goes here");
	}
	
	@After("@regression")
	public void tearDown2() {
		System.out.println("Teardown steps goes here");
	}
	
	@Given("User is in sigin/login page")
	public void user_is_in_login_page() throws IOException {
		WebDriver driver = BaseTest.getBrowserType("chrome", false);
		lp = new LoginPage(driver);
		driver.get(FileUtils.readLoginTestData("prod.app.url"));
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_username_and_password(String username, String pass) throws IOException {
		lp.username.sendKeys(FileUtils.readLoginTestData("prod.username"));
		lp.password.sendKeys(FileUtils.readLoginTestData("prod.password"));
		lp.loginButton.click();
		System.out.println(username +" " + pass);
	}

	@Then("User should land on homepage")
	public void user_should_land_on_homepage() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("BDD");
		Assert.assertEquals("", "");
	}

	@When("User enters invalid username and password")
	public void user_enters_invalid_username_and_password() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("BDD");
	}

	@Then("User should see error message(s)")
	public void user_should_see_error_message() {
	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
		System.out.println("BDD");
	}
	
	@Then("User should see scores")
	public void user_should_see_scores(DataTable dataTable) {
	
	    List<Map<String, String>> scores = dataTable.asMaps();
	    for (Map<String, String> score : scores) {
			System.out.print(score.get("scores")+" ");
			System.out.print(score.get("names")+" ");
		}
	}

}
