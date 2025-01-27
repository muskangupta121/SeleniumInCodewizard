package qa.tests;

import java.awt.AWTException;

import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.GetStartedEvents;
import pageEvents.LoginPageEvents;
import pageEvents.modelLibEvents;
import utils.ElementFetch;

public class ModelUpload extends BaseTest{
	
	ElementFetch ele = new ElementFetch();
	GetStartedEvents getStartedPage = new GetStartedEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	modelLibEvents modelUpload = new modelLibEvents();
	
	@Test
  public void ModelLib() throws AWTException, InterruptedException {
		getStartedPage.getStartedBtn();
		loginPage.enterCredentials();
		modelUpload.uploadModel();
		modelUpload.verifyModelSaved();
		
  }
}