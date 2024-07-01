package Task18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) throws Exception   {
		// Q.2 Task18
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
			
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		
		WebElement element1 = driver.findElement(By.xpath("//div[contains(@id,'draggable')]"));
		
		Thread.sleep(3000);
		WebElement element2 = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		Actions act = new Actions(driver);
		act.dragAndDrop(element1, element2);
		act.build().perform();
		
		//Verifying the color after drop
		
		String Expectedcolorafterdrop = "#fffa90";
		
		Thread.sleep(300);
		
		String Actualcolor = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable ui-state-highlight']")).getCssValue("background-color");
		
		Thread.sleep(300);
		
		System.out.println(Actualcolor);
		
		Thread.sleep(300);
		
		Color Hexvalue = Color.fromString(Actualcolor);
		
		String Actualcolorafterdrop = Hexvalue.asHex();
		
		if(Expectedcolorafterdrop.equals(Actualcolorafterdrop)) {
			System.out.println("DragAndDrop Operation is sucessful");
		} else {
			System.out.println("DragAndDrop Operation is unsucessful");
		}
		
		//Verifying the dropped text
		String Expectedafterdroptext = "Dropped!";
		
		Thread.sleep(3000);
		String actualtext = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();
		String Actualtextafterdrop = actualtext;
		
		if(Expectedafterdroptext.equals(Actualtextafterdrop)) {
			System.out.println("Text is correct");
		} else {
			System.out.println("Text is incorrect");
		}

	}

}
