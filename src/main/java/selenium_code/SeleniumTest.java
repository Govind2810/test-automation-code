package selenium_code;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
	
	static String chromedriverPath = "D:\\VISHAL\\eclipse-workspace\\selenium-automation\\src\\main\\java\\selenium_code\\chromedriver.exe";
    
	public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        // Optional: Set Chrome options (e.g., to avoid notifications, run headless)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Open browser in maximized mode

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver(options);

        try {
            // Implicit wait (applies to all elements)
            // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            // Open the practice website
            driver.get("https://the-internet.herokuapp.com/login");

            // Locate the Username field using explicit wait
            WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement username = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
            
            // Input Username
            username.sendKeys("tomsmith");

            // Locate the Password field using Fluent Wait
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(15))
                    .pollingEvery(Duration.ofSeconds(2))
                    .ignoring(NoSuchElementException.class);
            
            WebElement password = fluentWait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver driver) {
                    WebElement element = driver.findElement(By.id("password"));
                    if (element.isDisplayed()) {
                        return element;
                    }
                    return null;
                }
            });
            
            fluentWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("password"))));
            
            // WebElement password = fluentWait.until(driver1 -> driver1.findElement(By.id("password")));
            
            
            
            // Input Password
            password.sendKeys("SuperSecretPassword!");

            // Click the login button with an explicit wait
            WebElement loginButton = explicitWait.until(ExpectedConditions.elementToBeClickable(By.className("radius")));
            loginButton.click();

            // Check for success message using explicit wait
            WebElement successMessage = explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
            if (successMessage.getText().contains("You logged into a secure area!")) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

