package qa.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.BackendAppEvents;
import pageEvents.GetStartedEvents;
import pageEvents.LoginPageEvents;
import pageEvents.uploadModelBeEvents;
import utils.ElementFetch;

public class BeModelUpload extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	GetStartedEvents getStartedPage = new GetStartedEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	uploadModelBeEvents model = new uploadModelBeEvents();
	
	@Test
  public void ModelUploadBe() throws InterruptedException, IOException {
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
