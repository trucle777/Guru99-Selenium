package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.RegisterPage;

//Test Register a new user successfully
public class RegisterTest {
	
	WebDriver driver;
	RegisterPage registerPage;
//Pre-condition: Navigate to https://demo.guru99.com/test/newtours/
	@Before
	public void setUp() {
		System.setProperty("webDriver.chrome.driver",
				System.getProperty("user.home")+"/selenium/tools/chromedriver");
	driver = new ChromeDriver();
	driver.get("https://demo.guru99.com/test/newtours/");
	registerPage = new RegisterPage(driver);
	}
	
	//Test Register a new user successfully
	@Test
	public void testRegisterSuccessfully() {
		// Click tab REGISTER
		registerPage.clickRegisterTab();
		
		//Input valid information
		//• First Name: Truc
		//• Last Name: Le
		//• Phone: 0909999999
		//• Email: trucle99@gmail.com
		//• Address: 123 Duong B
		//• City: Thu Duc
		//• Province: Ho Chi Minh
		//• Postal Code: 71300
		//• Country: VIETNAM
		//• Username: truc99
		//• Password: 123456
		registerPage.inputText(registerPage.firstNameField, "Truc");
		registerPage.inputText(registerPage.lastNameField, "Le");
		registerPage.inputText(registerPage.phoneField, "0909999999");
		registerPage.inputText(registerPage.emailField, "trucle99@gmail.com");
		registerPage.inputText(registerPage.addressField, "123 Duong B");
		registerPage.inputText(registerPage.cityField, "Thu Duc");
		registerPage.inputText(registerPage.stateField, "Ho Chi Minh");
		registerPage.inputText(registerPage.postalCodeField, "71300");
		registerPage.selectCountry("VIETNAM");
		registerPage.inputText(registerPage.userNameField, "truc99");
		registerPage.inputText(registerPage.passwordField, "123456");
		registerPage.inputText(registerPage.confirmPasswordField, "123456");
		
		//Click Submit
		registerPage.clickButton(registerPage.submitButton);
		
		// Check the message if register successfully
		String expectRegisterSMS = "Your user name is truc99.";
		String actualRegisterSMS = registerPage.getSuccessRegisterSMS();
		System.out.println("The actual register sms is: "+ actualRegisterSMS);
		Assert.assertTrue("Expected title to contain:" + expectRegisterSMS, 
				actualRegisterSMS.contains(expectRegisterSMS));
		
	}

	@After
	public void closeBrowser() {
		if( driver != null ) {
			driver.quit();
		}
	}
	
}