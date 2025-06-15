package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;
import pages.RegisterPage;

//Test Register a new user successfully
public class RegisterTest {
	
	WebDriver driver;
	RegisterPage RegisterPage;
		
//Pre-condition: Navigate to https://demo.guru99.com/test/newtours/
	@Before
	public void setUp() {
		System.setProperty("webDriver.chrome.driver",
				System.getProperty("user.home")+"/selenium/tools/chromedriver");
	driver = new ChromeDriver();
	driver.get("https://demo.guru99.com/test/newtours/");
	RegisterPage = new RegisterPage(driver);
	}
	
	//Test Register a new user successfully
	@Test
	public void testRegisterSuccessfully() {
//		1. Click tab REGISTER
		RegisterPage.clickRegister();
		
//		2. Input valid information
//		  • First Name: Truc
//		  • Last Name: Le
//		  • Phone: 0909999999
//		  • Email: trucle99@gmail.com
//		  • Address: 123 Duong B
//		  • City: Thu Duc
//		  • Province: Ho Chi Minh
//		  • Postal Code: 71300
//		  • Country: VietNam
//		  • Username: truc99
//		  • Password: 123456

		
		RegisterPage.inputText(RegisterPage.firstNameField, "Truc");
		RegisterPage.inputText(RegisterPage.lastNameField, "Le");
		RegisterPage.inputText(RegisterPage.phoneField, "0909999999");
		RegisterPage.inputText(RegisterPage.emailField, "trucle99@gmail.com");
		RegisterPage.inputText(RegisterPage.addressField, "123 Duong B");
		RegisterPage.inputText(RegisterPage.cityField, "Thu Duc");
		RegisterPage.inputText(RegisterPage.stateField, "Ho Chi Minh");
		RegisterPage.inputText(RegisterPage.postalCodeField, "71300");
		RegisterPage.clickCountryDropdown();
		
		RegisterPage.inputText(RegisterPage.userNameField, "truc99");
		RegisterPage.inputText(RegisterPage.passwordField, "123456");
		RegisterPage.inputText(RegisterPage.confirmPasswordField, "123456");
		
//		3. Click Submit
		RegisterPage.clickSubmitRegister();
		
		// Check the message if register successfully
		String expectRegisterSMS = "Your user name is truc99.";
		String actualRegisterSMS = RegisterPage.getSuccessRegisterSMS();
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
