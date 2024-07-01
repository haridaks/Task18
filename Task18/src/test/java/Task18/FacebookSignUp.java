package Task18;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookSignUp {

	public static void main(String[] args) throws InterruptedException {
		// Q.1 Task18
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		String Expectedurl = "https://www.facebook.com/";
			
		driver.get("https://www.facebook.com/");
		
		String actualurl =  driver.getCurrentUrl();
		//Verifying the landed page
	    if (actualurl.equals(Expectedurl)) {
	    	System.out.println("Landed sucessfully");
	    } else {
	    	System.out.println("Landing was unsucessful");
	    }
		
		driver.manage().window().maximize();
		
	    Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("firstname")).sendKeys("Test");
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("lastname")).sendKeys("User");
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("reg_email__")).sendKeys("testuser@test.com");
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys("testuser@test.com");
		
		driver.findElement(By.name("reg_passwd__")).sendKeys("123456");
		
		Thread.sleep(3000);
		
	   /* List<WebElement> Birthday = driver.findElements(By.xpath("//select[@id='day']/option"));
		System.out.println("Total days displayed is" + Birthday.size()); */ 
		
		WebElement bd = driver.findElement(By.xpath("//select[@id='day']"));
		
		Thread.sleep(3000);
		
		// slect class
		
		Select day = new Select(bd);
				
	    // selecting day By visible Text
				
	    day.selectByVisibleText("11");
	    
	    Thread.sleep(3000);
	    // selecting month By visible Text
	    WebElement bm = driver.findElement(By.xpath("//select[@id='month']"));
	    Thread.sleep(3000);
	    Select month = new Select(bm);
	    
	    month.selectByVisibleText("May");
	    
	    Thread.sleep(3000);
	    
	    WebElement by = driver.findElement(By.xpath("//select[@id='year']"));
	    Thread.sleep(3000);
	    // selecting year By visible Text
	    Select year = new Select(by);
	    
	    year.selectByVisibleText("1985");
	    
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//label[text()='Female']")).click();
	    Thread.sleep(3000);
		
	    driver.findElement(By.name("websubmit")).click();
	    
	    System.out.println("sucessful");
		

	}

}
