package pageEvents;

import org.testng.Assert;

import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {
	
		ElementFetch ele = new ElementFetch();
		public void verifyIfLoginPageLoaded() 
		{
			Assert.assertTrue(ele.getWebElements("XPATH", LoginPageElements.logintext).size()>0, "Element not found");
		}
		public void enterCredentials() 
		{
			ele.getWebElement("ID", LoginPageElements.username).sendKeys("muskan@replicacia.com");
			ele.getWebElement("ID", LoginPageElements.password).sendKeys("Mus@1234");
			ele.getWebElement("XPATH", LoginPageElements.logintext).click();
		}
		
}
