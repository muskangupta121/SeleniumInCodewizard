package pageEvents;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.BaseTest;
import pageObjects.BackendAppElements;
import pageObjects.modelLibElements;
import utils.ElementFetch;

public class modelLibEvents extends BaseTest{
	ElementFetch ele = new ElementFetch();
	
	public void uploadModel() throws AWTException, InterruptedException {
		ele.getWebElement("XPATH", modelLibElements.selectTab).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(7));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Upload a File']")));
		
		driver.findElement(By.xpath("//div/img[@src='images/upload-icon.svg']")).click();
		//ele.getWebElement("XPATH", modelLibElements.uploadTag).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()='Browse From Your Device']")).click();

        Robot robot = new Robot();
        robot.delay(2000);

        // Copy file path to clipboard
        StringSelection filePath = new StringSelection("D:\\Downloads\\hritikdocs\\BookingModel.mdj");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filePath, null);

        // Paste the file path
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
		
        driver.findElement(By.xpath("//input[@placeholder='Enter the version of model']")).sendKeys("v1");
		
		//WebElement staticDropdown = driver.findElement(By.xpath("//div[text()='Select Industry']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".css-ozzdio")));
        dropdown.click();
        
        WebElement ecom = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        driver.findElement(By.xpath("//input[@id='react-select-2-input']")).sendKeys("Ecommerce");
        ecom.sendKeys(Keys.RETURN); 
        
        //dropdown.sendKeys("HealthCare");
        
        
        Thread.sleep(5000); 
        
        driver.findElement(By.xpath("//button[text()='Save']")).click();
	}
	
	public void verifyModelSaved() {
		Assert.assertTrue(ele.getWebElements("XPATH", modelLibElements.verifyTxt).size()>0, "There is issue in uploading design");
	}
}
