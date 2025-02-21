package pageEvents;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import utils.ElementFetch;

public class YourModelFe extends BaseTest{
	ElementFetch ele = new ElementFetch();
	public void feGenerate() throws InterruptedException {
	driver.findElement(By.xpath("//span[text()='Get started with a new frontend project by choosing or uploading a design model']")).click();
	Random ran = new Random();
	String appName = "TestFeApp" + ran.nextInt(100);
	driver.findElement(By.name("ProjectName")).sendKeys(appName);
	driver.findElement(By.xpath("//button[text()='Create']")).click();
	driver.findElement(By.xpath("//span[text()='React']")).click();
	
	driver.findElement(By.xpath("//button[text()='Your APIs']")).click();
	
	
     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'TestApp')]")));
     //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='images/api_icon.svg'][1]")));
 
     // Click on the element
     JavascriptExecutor js = (JavascriptExecutor) driver;
     js.executeScript("arguments[0].click();", button);
     
	/* WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement yourApi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='running']")));
	yourApi.click();
    driver.findElement(By.xpath("//button[text()='running']"));
	*/
    
     driver.findElement(By.xpath("//button[text()='Add screen']")).click(); 
     
     WebElement secondScr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Add screen'])[1]")));
     secondScr.click();
     WebElement config = driver.findElement(By.xpath("//button[text()='Configure Screens']"));
		config.click();
		try {
         Thread.sleep(5000);  // Adjust the sleep time if necessary or use WebDriverWait
     } catch (InterruptedException e) {
         e.printStackTrace();
     }
		
		Set<String> windowIds = driver.getWindowHandles();
		
		for(String windowI: windowIds) {
			System.out.println(windowI);
		}
		Thread.sleep(5000);
	    
		
		Iterator<String> it = windowIds.iterator();
		
		String parentId = it.next();
		//String childId = it.next();
		
		driver.switchTo().window(parentId);
		driver.switchTo().window(it.next());
		driver.findElement(By.xpath("//span[text()='Form Layout']/parent::div/parent::div/parent::div/img")).click();
		//driver.findElement(By.xpath("//div[@role='combobox']")).click();
		driver.findElement(By.xpath("//div[text()='Select API']")).click();
		
		driver.findElement(By.xpath("//ul[@role='listbox']/li[2]")).click();
		
		driver.findElement(By.xpath("//div[text()='Select API']")).click();
		driver.findElement(By.xpath("//ul[@role='listbox']/li[2]")).click();
	}
}
