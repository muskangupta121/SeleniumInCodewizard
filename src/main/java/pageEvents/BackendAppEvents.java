package pageEvents;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.BackendAppElements;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class BackendAppEvents extends BaseTest{
	ElementFetch ele = new ElementFetch();
	public void verifyIfDashboardLoaded() 
	{
		Assert.assertTrue(ele.getWebElements("XPATH", BackendAppElements.homeText).size()>0, "Dashboard not visible");
	}
	public void createExistingBe() throws InterruptedException 
	{
		ele.getWebElement("XPATH", BackendAppElements.newbe).click();
		Random ran = new Random();
		String appName = "TestApp" + ran.nextInt(100);
		ele.getWebElement("NAME", BackendAppElements.projectName).sendKeys(appName);
		ele.getWebElement("XPATH", BackendAppElements.createBtn).click();
		ele.getWebElement("XPATH", BackendAppElements.selectModel).click();
		ele.getWebElement("XPATH", BackendAppElements.backEnd).click();
		ele.getWebElement("XPATH", BackendAppElements.selectDb).click();
		ele.getWebElement("XPATH", BackendAppElements.selectCap1).click();
		ele.getWebElement("XPATH", BackendAppElements.selectCap2).click();
		//ele.getWebElement("XPATH", BackendAppElements.basicDetails).click();	
		//ele.getWebElement("XPATH", BackendAppElements.mouse).click();
		//WebElement staticDropdown = driver.findElement(By.xpath("//div[@class='css-8akrpk'][1]"));
		driver.findElement(By.xpath("//img[contains(@class,'rotate-0')]")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".css-5wzqtd-singleValue")));
        dropdown.click();
        
        //dropdown.sendKeys("HealthCare");
        

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
