package pageEvents;

import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.BackendAppElements;
import utils.ElementFetch;

public class ExistingFeEvents extends BaseTest{
	ElementFetch ele = new ElementFetch();
	public void generateFe() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Get started with a new frontend project by choosing or uploading a design model']")).click();
		Random ran = new Random();
		String appName = "TestFeApp" + ran.nextInt(100);
		driver.findElement(By.name("ProjectName")).sendKeys(appName);
		driver.findElement(By.xpath("//button[text()='Create']")).click();
		driver.findElement(By.xpath("//span[text()='React']")).click();
		driver.findElement(By.xpath("//span[text()='PetCare Starter']")).click();
		
		//Selecting Form screen
		driver.findElement(By.xpath("//button[text()='Add screen']")).click();
		//driver.findElement(By.xpath("//span[text()='Form']/following-sibling::div[2]")).click();
		
		//Selecting Table Screen
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement secondScr = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[text()='Add screen'])[1]")));
        secondScr.click();
		//driver.findElement(By.xpath("//button[text()='Add screen'][2]")).click();
		//driver.findElement(By.xpath("//span[text()='Table']/following-sibling::div[2]")).click();
		
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
		System.out.println(driver.getTitle());
		
		//WebElement formScr = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[text()='Add screen'])[1]")));
        //formScr.click();
		driver.findElement(By.xpath("//span[text()='Form Layout']/parent::div/parent::div/parent::div/img")).click();
		//driver.findElement(By.xpath("//div[@role='combobox']")).click();
		driver.findElement(By.xpath("//div[text()='Select API']")).click();
		driver.findElement(By.xpath("//li[@name='Pet']")).click();
		driver.findElement(By.xpath("//div[text()='Select API']")).click();
		driver.findElement(By.xpath("//li[text()='Pet']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		driver.findElement(By.xpath("//span[text()='Table Layout']/parent::div/parent::div/parent::div/img")).click();
		driver.findElement(By.xpath("//div[text()='Select API']")).click();
		driver.findElement(By.xpath("//li[text()='Pet']")).click();
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		
		driver.findElement(By.xpath("//button[@aria-label='menu']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'MuiListItem')]/span[text()='Table Layout']")).click();
		driver.findElement(By.xpath("//div[text()='Select Screen']")).click();
		driver.findElement(By.xpath("//li[text()='Table Layout']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Pets");		
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		
		WebElement returnCw = driver.findElement(By.xpath("//button[text()='Return to Code-Wizard']"));
		//Switch to codewizard after saving
		
		returnCw.click();
		try {
            Thread.sleep(5000);  // Adjust the sleep time if necessary or use WebDriverWait
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle());
		
		
		driver.findElement(By.xpath("//span[text()='Docker Compose']")).click();
		driver.findElement(By.xpath("//span[text()='Dockerfile']")).click();
		
		 driver.findElement(By.xpath("//img[contains(@class,'rotate-0')]")).click();
		
		
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".css-5wzqtd-singleValue")));
        dropdown.click();
        
        Thread.sleep(3000); 
		
		WebElement token = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        driver.findElement(By.xpath("//input[@id='react-select-2-input']")).sendKeys("Codewizard Public Repo");
        token.sendKeys(Keys.RETURN); 
        
        driver.findElement(By.xpath("//div[text()='Nginx']")).click();
        
        Thread.sleep(7000);
        WebElement config2 = driver.findElement(By.xpath("//button[text()='Confirm']"));		
		config2.click(); 
	}
	
	public void verifyIfGeneratePageLoaded() 
	{
		Assert.assertTrue(ele.getWebElements("XPATH", BackendAppElements.generateBtn).size()>0, "There is issue in configuration frontend");
	}
	
	public void generateApp() {
		driver.findElement(By.xpath("//button[text()='Generate App']")).click();
	}
	
	public void verifyIfGenerationDone() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement deployBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Deploy & Run']")));
		Assert.assertTrue(ele.getWebElements("XPATH", BackendAppElements.deployBtn).size()>0,"Issue in generating frontend app");
	}
	
	public void deployApp() {
		driver.findElement(By.xpath("//button[text()='Deploy & Run']")).click();
	}
	
	public void verifyAppDeployed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement successEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Success']")));
        
		//Assert.assertTrue(successEle.getText()=="Success","Issue in deploying Backend app");
        Assert.assertTrue(ele.getWebElements("XPATH", BackendAppElements.successBtn).size()>0,"Issue in deploying Frontend app");
	}
}
