package E2E.Selen2Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SelectClass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\haqar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		//driver.get("http://automationpractice.com/index.php");
		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Chittagong')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),' Chennai (MAA)')]")).click();
		WebDriverWait wait= new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//a[@class='ui-state-default'][contains(text(),'30')])[2]"))));
		//driver.findElement(By.xpath("//span[@class='ui-datepicker-month'][contains(text(),'October')]"))
		driver.findElement(By.xpath("(//a[@class='ui-state-default'][contains(text(),'30')])[2]")).click();
		
		driver.findElement(By.cssSelector("#divpaxinfo")).click();
		Select sl=new Select(driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_Adult")));
		sl.selectByValue("9");
		
		Select slc=new Select(driver.findElement(By.cssSelector("#ctl00_mainContent_ddl_Child")));
		slc.selectByValue("1");
		String actual=driver.switchTo().alert().getText();
		System.out.println(actual);
		String expected="You are allowed a maximum of 9 passengers per booking online. If your party is larger than this, please call our reservation center.";
		Assert.assertEquals(expected, actual);
		driver.switchTo().alert().accept();
		Select slcur= new Select (driver.findElement(By.cssSelector("[name='ctl00$mainContent$DropDownListCurrency']")));
		slcur.selectByVisibleText("USD");
		WebElement disStu=driver.findElement(By.xpath("//label[contains(text(),'Student')]"));
		disStu.click();
		//disStu.isSelected();
		if(disStu.isSelected()){
			System.out.println("CheckBox for Student Discount is NOT Working");
		}else{
			System.out.println("CheckBox for Student Discount is Working");
		}
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		System.out.println(driver.getTitle());
	}

}
