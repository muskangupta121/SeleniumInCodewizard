package pageObjects;

public interface BackendAppElements {
	String homeText="//span[text()='Home']";
	String newbe = "//span[text()='Get started with a new backend project by choosing or uploading a design model']";
	String projectName = "ProjectName";
	String createBtn = "//button[text()='Create']";
	String selectModel = "//div[contains(@class,'cursor-pointer')]"; 
	String backEnd = "//span[text()='Spring OData']";
	String selectDb = "//span[text()='PostgreSQL']";
	String selectCap1 = "//span[text()='Docker Compose']";
	String selectCap2 = "//span[text()='Dockerfile']";
	String basicDetails = "//img[contains(@class,'rotate-0')]";
	String basicDetails2 = "//div[text()='Maven']";
	String mouse = "//div[@class='css-8akrpk'][1]";
	String confirmBtn = "//button[text()='Confirm']";
	String generateBtn = "//button[text()='Generate App']";
	String deployBtn = "//button[text()='Deploy & Run']";
	String successBtn = "//h6[text()='Success']";
}
