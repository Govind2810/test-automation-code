package interview_questions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorExamples {

	WebDriver driver = new ChromeDriver();

	public void scrollPageExample() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll down by 1000 pixels
		js.executeScript("window.scrollBy(0,1000)");

		// Scroll to the bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
	}
	
	// Scrolls the page until the specified element is in view.
	public void scrollIntoView() {
		
		WebElement element = driver.findElement(By.id("elementToScroll"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll element into view
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	
	// JavaScript can enable disabled elements to perform actions on them.
	public void handlingDisabledElements() {
		
		WebElement disabledElement = driver.findElement(By.id("disabledInput"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Remove the 'disabled' attribute
		js.executeScript("arguments[0].removeAttribute('disabled');", disabledElement);

		// Now interact with the element
		disabledElement.sendKeys("Enabled using JavaScript");

	}

	public void clickUsingJS() {

		WebElement button = driver.findElement(By.id("hiddenButton"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", button);
		
	}
	
	// Use JavaScript to input text when sendKeys() fails
	public void enteringTextIntoFields() {
		
		WebElement textBox = driver.findElement(By.id("inputField"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Sample Text';", textBox);
		
	}
	
	// 	This is useful for debugging or visualizing elements during test execution.

	public void highlightingElements() {
		
		WebElement element = driver.findElement(By.id("elementToHighlight"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);

	}
	
	public void retrievingPageTitleOrOtherProperties() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Get the page title
		String title = (String) js.executeScript("return document.title;");
		System.out.println("Page Title: " + title);

		// Get the URL
		String url = (String) js.executeScript("return document.URL;");
		System.out.println("Page URL: " + url);

	}

	public static void main(String[] args) {

	}

	/*
	 * 
	 * The JavaScriptExecutor interface in Selenium is used to execute JavaScript
	 * code directly within the browser. It is helpful when:
	 * 
	 * - Certain elements or actions are not directly accessible using standard
	 * WebDriver methods. - You need to manipulate the DOM directly or execute
	 * JavaScript for specific tasks.
	 * 
	 */
}
