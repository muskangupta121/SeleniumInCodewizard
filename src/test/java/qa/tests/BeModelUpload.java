package qa.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.BackendAppEvents;
import pageEvents.GetStartedEvents;
import pageEvents.LoginPageEvents;
import pageEvents.YourModelBe;
import pageEvents.uploadModelBeEvents;
import utils.ElementFetch;

public class BeModelUpload extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	GetStartedEvents getStartedPage = new GetStartedEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	YourModelBe model = new YourModelBe();
	
	@Test
  public void ModelUploadBe() throws InterruptedException, IOException, AWTException {
		getStartedPage.getStartedBtn();

		loginPage.enterCredentials();
		model.uploadModel();
		model.verifyIfGeneratePageLoaded();
		model.generateApp();
		model.verifyIfGenerationDone();
		model.deployApp();
		model.verifyAppDeployed();
		
  }
}
