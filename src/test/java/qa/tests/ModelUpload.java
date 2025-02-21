package qa.tests;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.GetStartedEvents;
import pageEvents.LoginPageEvents;
import pageEvents.YourModelBe;
import pageEvents.modelLibEvents;
import utils.ElementFetch;

public class ModelUpload extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	GetStartedEvents getStartedPage = new GetStartedEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	YourModelBe yourmodel = new YourModelBe();
	
	@Test
  public void ModelLib() throws AWTException, InterruptedException, IOException {
		getStartedPage.getStartedBtn();
		loginPage.enterCredentials();
		yourmodel.uploadModel();
		//yourmodel.verifyModelSaved();
		
  }
}