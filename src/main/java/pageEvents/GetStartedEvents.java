package pageEvents;

import pageObjects.GetStartedElements;
import utils.ElementFetch;

public class GetStartedEvents {
	ElementFetch ele = new ElementFetch();
	public void getStartedBtn() 
	{
		ele.getWebElement("XPATH", GetStartedElements.getStartedBtnText).click();
	}
}
