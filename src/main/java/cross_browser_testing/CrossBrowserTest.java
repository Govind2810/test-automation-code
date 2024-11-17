package cross_browser_testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.edge.EdgeDriver;

public class CrossBrowserTest {

    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void setUp(String browser) {
        // Setup WebDriver based on the browser parameter
        if (browser.equalsIgnoreCase("chrome")) {
        	
            // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        	
        	WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
        	
            // System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
        	WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
        	
            // System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
        	WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @Test
    public void crossBrowserTest() {
        // Open a website
        driver.get("https://example.com");

        // Perform test actions (Example: Check title)
        String pageTitle = driver.getTitle();
        System.out.println("Page Title: " + pageTitle);

        // Add your test logic here (e.g., verifying elements, performing clicks, etc.)
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}

