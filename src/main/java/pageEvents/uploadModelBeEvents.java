package pageEvents;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.BackendAppElements;
import pageObjects.uploadModelBeElements;
import utils.ElementFetch;

public class uploadModelBeEvents extends BaseTest{
	ElementFetch ele = new ElementFetch();
	
	@SuppressWarnings("deprecation")
	public void uploadModel() throws InterruptedException, IOException {
		ele.getWebElement("XPATH", uploadModelBeElements.newbe).click();
		ele.getWebElement("NAME", uploadModelBeElements.projectName).sendKeys("BackendTestApp");
		ele.getWebElement("XPATH", uploadModelBeElements.createBtn).click();
		ele.getWebElement("XPATH", uploadModelBeElements.designTab).click();
		ele.getWebElement("XPATH", uploadModelBeElements.uploadBtn).click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec(uploadModelBeElements.fileLocation);
		
		driver.findElement(By.xpath("//input[@placeholder='Enter the version of model']")).sendKeys("v1");
		
		//WebElement staticDropdown = driver.findElement(By.xpath("//div[text()='Select Industry']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".css-ozzdio")));
        dropdown.click();
        
        WebElement ecom = driver.findElement(By.xpath("//input[@id='react-select-5-input']"));
        driver.findElement(By.xpath("//input[@id='react-select-5-input']")).sendKeys("Ecommerce");
        ecom.sendKeys(Keys.RETURN); 
        
        //dropdown.sendKeys("HealthCare");
        

        Thread.sleep(5000); 
        
        driver.findElement(By.xpath("//button[text()='Save']")).click();
        
        Thread.sleep(10000); 
        driver.findElement(By.xpath("//span[text()='Spring OData']")).click();
        driver.findElement(By.xpath("//span[text()='PostgreSQL']")).click();
        driver.findElement(By.xpath("//span[text()='Dockerfile']")).click();
        driver.findElement(By.xpath("//span[text()='Docker Compose']")).click();
        
        driver.findElement(By.xpath("//img[contains(@class,'rotate-0')]")).click();
        
        WebElement gitDropdown  = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".css-5wzqtd-singleValue")));
        gitDropdown.click();
        
        Thread.sleep(3000); 
		
		WebElement token = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        driver.findElement(By.xpath("//input[@id='react-select-2-input']")).sendKeys("Codewizard Public Repo");
        token.sendKeys(Keys.RETURN); 
        
        driver.findElement(By.xpath("//div[text()='Maven']")).click();
        
        Thread.sleep(7000);
        WebElement config = driver.findElement(By.xpath("//button[text()='Confirm']"));		
		config.click();
	}
	
	public void verifyIfGeneratePageLoaded() 
	{
		Assert.assertTrue(ele.getWebElements("XPATH", BackendAppElements.generateBtn).size()>0, "There is issue in configuration backend");
	}
	
	public void generateApp() {
		driver.findElement(By.xpath("//button[text()='Generate App']")).click();
	}
	
	public void verifyIfGenerationDone() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement deployBtn1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Deploy & Run']")));
		Assert.assertTrue(ele.getWebElements("XPATH", BackendAppElements.deployBtn).size()>0,"Issue in generating app");
	}
	
	public void deployApp() {
		driver.findElement(By.xpath("//button[text()='Deploy & Run']")).click();
	}
	
	public void verifyAppDeployed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        WebElement successEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Success']")));
        
		//Assert.assertTrue(successEle.getText()=="Success","Issue in deploying Backend app");
        Assert.assertTrue(ele.getWebElements("XPATH", BackendAppElements.successBtn).size()>0,"Issue in deploying Backend app");
	}
}
