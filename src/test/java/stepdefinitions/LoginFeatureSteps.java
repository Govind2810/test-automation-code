package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFeatureSteps {
	
	WebDriver driver;

	@Given("browser is open and ready for automation")
	public void browser_is_open_and_ready_for_automation() {
	    
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
        driver.manage().window().maximize();
	}
	
	@And("user is on login page")
	public void user_is_on_login_page() {
		
		
	}

	@When("user enters the valid username and password")
	public void user_enters_the_valid_username_and_password() {
	   
		
	}
	
	@And("user clicks on login button")
	public void user_clicks_on_login_button() {
		
		
	}

	@Then("user should be able to login")
	public void user_should_be_able_to_login() {
	    
		
	}
}
