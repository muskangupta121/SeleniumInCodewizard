package pageEvents;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseTest;

public class SignupPageEvents extends BaseTest{
	public void signup() throws InterruptedException {
		driver.findElement(By.xpath("//button[text()='Get Started']")).click();
		driver.findElement(By.xpath("//a[text()='Sign up']")).click();
		
		Random ran = new Random();
		String username = "muskan" + ran.nextInt(1000) + "@gmail.com";
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys("Mus@3100");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		try {
			WebElement ele = driver.findElement(By.xpath("//p[text()='Something went wrong, please try again later']"));
			
			if(ele.isDisplayed()) {
				driver.findElement(By.id("email")).clear();
				driver.findElement(By.id("email")).sendKeys(username);
				driver.findElement(By.id("password")).sendKeys("Mus@3100");
				driver.findElement(By.xpath("//button[text()='Continue']")).click();
			}
		}
		catch (Exception e) {      
            System.out.println(e);
        } 
		
		Set<String> windowIds = driver.getWindowHandles();
		Thread.sleep(5000);
		Iterator<String> it = windowIds.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@value='new']")).click();
		driver.findElement(By.xpath("//input[@value='work']")).click();
		driver.findElement(By.xpath("//button[text()='Get Started']")).click();
	}
}
