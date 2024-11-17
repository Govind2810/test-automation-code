package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSearchSteps {

	WebDriver driver;
	
	@Given("browser is open")
	public void browser_is_open() {
	    
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(45));
        driver.manage().window().maximize();
	}

	@And("user is on google search page")
	public void user_is_on_google_search_page() {
	    
		driver.get("https://www.google.com/");
	}

	@When("user enters text in searchbox")
	public void user_enters_text_in_searchbox() {
	    
		driver.findElement(By.name("q")).sendKeys("Automation Testing");
	}

	@And("clicks on search button")
	public void clicks_on_search_button() {
	    
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

	@Then("user is navigated to the search results page")
	public void user_is_navigated_to_the_search_results_page() {
	    
		driver.getPageSource().contains("Test automation");
	}
}
