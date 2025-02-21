package qa.fetests;

import base.BaseTest;
import pageEvents.GetStartedEvents;
import pageEvents.LoginPageEvents;
import pageEvents.ExistingFeEvents;
import utils.ElementFetch;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExistingFeApp extends BaseTest{
	ElementFetch ele = new ElementFetch();
	GetStartedEvents getStartedPage = new GetStartedEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	ExistingFeEvents fe = new ExistingFeEvents();
	
	@Test
	public void login()
	{
		getStartedPage.getStartedBtn();
		loginPage.verifyIfLoginPageLoaded();
		loginPage.enterCredentials();
	}
	
	@AfterTest
	public void generate() throws InterruptedException
	{
		fe.generateFe();
		fe.verifyIfGeneratePageLoaded();
		fe.generateApp();
		fe.verifyIfGenerationDone();
		fe.deployApp();
		fe.verifyAppDeployed();
	}
	
	
}
