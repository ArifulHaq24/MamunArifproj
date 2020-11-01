package E2E.Selen2Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyClass2 {
	static String driverPath=System.getProperty("user.dir");
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", driverPath +"\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//driver.get("http://automationpractice.com/index.php");
		driver.get("http://automationpractice.com/index.php?id_category=5&controller=category");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement drop= driver.findElement(By.cssSelector("#selectProductSort"));
		//WebDriverWait wait= new WebDriverWait(driver,20);
		//wait.until(ExpectedConditions.visibilityOf(drop));
		Select sld= new Select(drop);
		sld.selectByValue("name:asc");
		//Actions ac= new Actions(driver);
	}

}
