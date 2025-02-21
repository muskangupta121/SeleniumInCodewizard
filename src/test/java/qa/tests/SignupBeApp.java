package qa.tests;

import org.testng.annotations.Test;
import base.BaseTest;
import pageEvents.BackendAppEvents;
import pageEvents.SignupPageEvents;
import utils.ElementFetch;

public class SignupBeApp  extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	SignupPageEvents signup = new SignupPageEvents();
	BackendAppEvents beApp = new BackendAppEvents();
	
	@Test
  public void signupBe() throws InterruptedException {
		signup.signup();
		beApp.createExistingBe();
		beApp.verifyIfGeneratePageLoaded();
		beApp.generateApp();
		beApp.verifyIfGenerationDone();
		beApp.deployApp();
		beApp.verifyAppDeployed();
  }

}
