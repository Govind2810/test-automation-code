package interview_questions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassExamples {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("xpath"));
		WebElement targetElement = driver.findElement(By.xpath("xpath"));
	
		// to execute the action.
		actions.perform(); 	
		
		// when chaining multiple actions.
		actions.build().perform();  	
	
		// click() : Simulates a single mouse click on an element.
		actions.click(element).perform();
	
		// clickAndHold() : Simulates clicking and holding the left mouse button on an element.
		actions.clickAndHold(element).perform();
	
		// release() : Simulates releasing the mouse button.
		actions.clickAndHold(element).moveToElement(targetElement).release().perform();
		
		// moveToElement() : Moves the mouse pointer to a specified element, often used for mouse hover.
		actions.moveToElement(element).perform();
		
		// contextClick() : Simulates a right-click on an element.
		actions.contextClick(element).perform();
		
		// doubleClick() : Simulates a double-click on an element.
		actions.doubleClick(element).perform();
		
		// dragAndDrop() : Drags an element from a source to a target.
		actions.dragAndDrop(element, targetElement).perform();
		
		// dragAndDropBy() : Drags an element by an offset (x, y).
		actions.dragAndDropBy(element, 100, 50).perform();
		
		// sendKeys() : Sends keys to the currently focused element or to a specific element.
		actions.sendKeys(Keys.ENTER).perform();
		actions.sendKeys(element, "Text to enter").perform();
		
		// keyDown() and keyUp() : Simulates pressing and releasing a key.
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform(); // Select all
		
		// build() and perform() : 
		// build() => Creates a composite action.
		// perform() => Executes the built or single action.
	
		actions.moveToElement(element).click().build().perform();
	
		// 1. Example: Hover and Click
		WebElement subMenuElement = driver.findElement(By.xpath("xpath"));
		actions.moveToElement(element).moveToElement(subMenuElement).click().perform();
		
		// 2. Example: Drag and Drop
		actions.clickAndHold(element).moveToElement(targetElement).release().perform();
		
	/*	
		Advantages of Actions Class: 
			1. Precision: Ideal for fine-grained interactions like drag-and-drop.
			2. Realistic Interaction: Mimics real user actions.
			3. Complexity Handling: Can chain multiple actions for complex workflows.
			
		Limitations:
			1. It may not work well with certain UI frameworks if the application is not well-developed.
			2. Requires precise element location strategies.
			3. Debugging issues in complex chains can be tricky.
	*/
	}
}
