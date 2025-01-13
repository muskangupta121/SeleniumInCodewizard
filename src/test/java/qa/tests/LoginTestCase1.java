package qa.tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.GetStartedEvents;
import pageEvents.LoginPageEvents;
import pageEvents.SignupPageEvents;
import utils.ElementFetch;

public class LoginTestCase1 extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	GetStartedEvents getStartedPage = new GetStartedEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	
	
	@Test
  public void EnterCreds() {
		getStartedPage.getStartedBtn();
		loginPage.verifyIfLoginPageLoaded();
		loginPage.enterCredentials();
  }
}
