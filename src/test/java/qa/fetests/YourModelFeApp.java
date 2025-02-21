package qa.fetests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.ExistingFeEvents;
import pageEvents.GetStartedEvents;
import pageEvents.LoginPageEvents;
import pageEvents.YourModelFe;
import utils.ElementFetch;

public class YourModelFeApp extends BaseTest{
	ElementFetch ele = new ElementFetch();
	GetStartedEvents getStartedPage = new GetStartedEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	YourModelFe fe = new YourModelFe();
	
	@Test
	public void login()
	{
		getStartedPage.getStartedBtn();
		loginPage.verifyIfLoginPageLoaded();
		loginPage.enterCredentials();
	}
	
	@AfterTest
	public void generateFe() throws InterruptedException
	{
		fe.feGenerate();
	}
	
}
