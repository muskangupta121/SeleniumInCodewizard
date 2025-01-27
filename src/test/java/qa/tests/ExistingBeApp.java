package qa.tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.BackendAppEvents;
import pageEvents.GetStartedEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class ExistingBeApp extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	GetStartedEvents getStartedPage = new GetStartedEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	BackendAppEvents beapp = new BackendAppEvents();
	
	@Test
  public void EnterCreds() throws InterruptedException {
		getStartedPage.getStartedBtn();
		loginPage.verifyIfLoginPageLoaded();
		loginPage.enterCredentials();
		beapp.verifyIfDashboardLoaded();
		beapp.createExistingBe();
		beapp.verifyIfGeneratePageLoaded();
		beapp.generateApp();
		beapp.verifyIfGenerationDone();
		beapp.deployApp();
		beapp.verifyAppDeployed();
  }
}
