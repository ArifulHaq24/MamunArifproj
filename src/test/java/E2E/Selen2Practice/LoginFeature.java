package E2E.Selen2Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFeature {
	WebDriver driver;
	Properties prop;
	String driverPath=System.getProperty("user.dir");
	
	public LoginFeature(){
	//Properties prop= new Properties();
	try {
		prop = new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\E2E\\Selen2Practice\\data.properties");
		prop.load(fis);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
		System.out.println( "File not Found");
	}catch(IOException e){
		e.getStackTrace();
		System.out.println( "File not Found");
	}
	}
	@BeforeMethod
	public void loginPage() {
		System.setProperty("webdriver.chrome.driver",
				(System.getProperty("user.dir")+ "//src//main//resources//driver//chromedriver.exe"));
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	

	/*@Test
	public void present() {

		// driver.findElement(By.cssSelector("#emal")).isDisplayed();
		try {
			driver.findElement(By.cssSelector("#email")).isDisplayed();
			// driver.findElement(By.cssSelector("#password")).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
			System.out.println("Email address field does not Exist");
			WebElement ele = driver.findElement(By.cssSelector("#email"));

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);
		}
		try {
			WebElement pass = driver.findElement(By.cssSelector("#passd"));
			pass.isDisplayed();
		} catch (Exception e) {
			// e.getStackTrace();
			String lm = e.getLocalizedMessage();
			// String w=e.getMessage();
			System.out.println(lm);
			// e.printStackTrace();
			// System.out.println("Password field does);
			WebElement ele2 = driver.findElement(By.cssSelector("#passwd"));

			JavascriptExecutor js = (JavascriptExecutor) driver;

			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele2);
		}

	}

		@Test
		public void positiveLogin1() {
			driver.findElement(By.cssSelector("#email")).sendKeys("test2mamun@gmail.com");
			driver.findElement(By.cssSelector("#passwd")).sendKeys("Abc123$");
			driver.findElement(By.cssSelector("button[name='SubmitLogin'")).click();
			String title=driver.getTitle();
			//System.out.println(title);
			Assert.assertTrue(true, title);
			Assert.assertEquals(title, "My account - My Store");
		}
		*/
		@Test
		public void negativeLogin(){
			driver.findElement(By.cssSelector("#email")).sendKeys(prop.getProperty("userEmail"));
			driver.findElement(By.cssSelector("#passwd")).sendKeys(prop.getProperty("invalidPass"));
			driver.findElement(By.cssSelector("button[name='SubmitLogin'")).click();
			driver.findElement(By.cssSelector(".alert.alert-danger")).isDisplayed();
			/*WebDriverWait wait= new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.alertIsPresent());
					
			System.out.println(driver.switchTo().alert().getText());*/
		}
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
			driver=null;
		}

}
	






















