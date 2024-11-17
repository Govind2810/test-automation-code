package interview_questions;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertClassExamples {

	public static void main(String[] args) {

		// Set up WebDriver and navigate to the example page
		WebDriver driver = new ChromeDriver();
		driver.get("https://example.com/alerts"); // Replace with your test URL

		/****************** **Simple Alert** - Handle a basic alert box *****************/
		WebElement simpleAlertButton = driver.findElement(By.id("simpleAlert"));
		simpleAlertButton.click(); // Click to trigger the alert

		// Switch focus to the alert
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println("Alert text: " + simpleAlert.getText()); // Fetch and print alert text
		simpleAlert.accept(); // Click OK to accept the alert
		System.out.println("Simple alert handled.");
		
		/********** Confirmation Alert - Handle a confirmation alert (OK/Cancel) ********/
		WebElement confirmAlertButton = driver.findElement(By.id("confirmAlert"));
		confirmAlertButton.click(); 	// Click to trigger the confirmation alert
		
		Alert confirmAlert = driver.switchTo().alert(); 	// Switch focus to the alert
		System.out.println("Confirmation alert text: " + confirmAlert.getText());
		confirmAlert.dismiss(); 							// Click Cancel to dismiss the alert
		System.out.println("Confirmation alert dismissed.");

		/************ Prompt Alert** - Handle a prompt alert with a text input **********/
		WebElement promptAlertButton = driver.findElement(By.id("promptAlert"));
		promptAlertButton.click(); 		// Click to trigger the prompt alert
		
		Alert promptAlert = driver.switchTo().alert(); // Switch focus to the alert
		System.out.println("Prompt alert text: " + promptAlert.getText());
		promptAlert.sendKeys("Test Input"); // Enter text into the prompt alert
		promptAlert.accept(); // Click OK to submit the text
		System.out.println("Prompt alert handled with input.");

		
		// Close the browser
		driver.quit();
	}

	/*
	 * 
	 * Explanation of Alert Class Methods: 1. accept(): Clicks the "OK" button on
	 * the alert. Used for both simple alerts and confirmation alerts.
	 * 
	 * 2. dismiss(): Clicks the "Cancel" button on the alert. Used for confirmation
	 * alerts where a dismissal action is required.
	 * 
	 * 3. getText(): Fetches the message displayed in the alert box. Useful for
	 * validating alert text in tests.
	 * 
	 * 4. sendKeys(String text) Inputs text into a prompt alert box. Works only for
	 * prompt alerts that allow user input.
	 * 
	 * 
	 * Interview-Friendly Explanation: What is the Alert class? The Alert class is
	 * used to interact with JavaScript alerts, confirmation dialogs, and prompt
	 * dialogs.
	 * 
	 * When do you use it? It is used whenever a JavaScript-based alert appears
	 * during test execution.
	 * 
	 * How do you handle multiple alert types? For a simple alert: Use accept(). For
	 * a confirmation alert: Use accept() or dismiss() based on the action. For a
	 * prompt alert: Use sendKeys() to input data and then accept() to confirm.
	 * 
	 */
}
