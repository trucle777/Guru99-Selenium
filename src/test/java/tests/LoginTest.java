package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;

//TC-001. Verify login functionality on Mercury Tours
public class LoginTest {

	WebDriver driver;
	LoginPage loginPage;
	
	@Before
	public void setUp() {
		System.setProperty("webDriver.chrome.driver",
				System.getProperty("user.home")+"/selenium/tools/chromedriver");
		
	//Open a browser and navigate to https://demo.guru99.com/test/newtours/
	driver = new ChromeDriver();
	driver.get("https://demo.guru99.com/test/newtours/");
	loginPage = new LoginPage(driver);
	}
	
	@Test
	public void testLoginSuccessfully() {
		
		//Choose tab "SIGN-ON"
		loginPage.clickSignOn();
		
		//Input the Username “mercury”.
		loginPage.inputUsername("mecury");
		
		//Input the Password "mercury".
		loginPage.inputPassword("mecury");
		
		//Click the” Submit" button	
		loginPage.clickButton();
		
		//waiting page loading
	//	loginPage.waitMessage();
		
		//Check if the message “Login Successfully” is displayed
		String actualMessage = loginPage.getMessage();
		String expectMessage = "Login Successfully";
		
		System.out.println("Actual message is: " + actualMessage);

		//Compare the Titles
		Assert.assertTrue("Expected title to contain:" + expectMessage, 
				actualMessage.contains(expectMessage));
	}
	
	@After
	public void closeBrowser() {
		if( driver != null ) {
			driver.quit();
		}
	}
}
