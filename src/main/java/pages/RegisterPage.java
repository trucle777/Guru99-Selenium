package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import pages.LoginPage;



public class RegisterPage {

	private By registerTab = By.linkText("REGISTER");
	private By submitButton = By.name("submit");

	public By firstNameField = By.name("firstName");
	public By lastNameField = By.name("lastName");
	public By phoneField = By.name("phone");
	public By emailField = By.name("userName");
	public By addressField = By.name("address1");
	public By cityField = By.name("city");
	public By stateField = By.name("state");
	public By postalCodeField = By.name("postalCode");
	public By countryDropdown = By.name("country");
	public By userNameField = By.id("email");
	public By passwordField = By.name("password");
	public By confirmPasswordField = By.name("confirmPassword");
	public By successRegisterSMS = By.xpath("//b[contains(text(),'Your user name is ')]");
	
	WebDriver driver;
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickRegister() {
		driver.findElement(registerTab).click();
	}
	
	public void inputText(By element, String value) {
		driver.findElement(element).sendKeys(value);
	}
	
	public void clickCountryDropdown() {
		driver.findElement(countryDropdown).click();
	}
	
	public void clickSubmitRegister() {
		driver.findElement(submitButton).click();
	}
	
	public String getSuccessRegisterSMS() {
		return driver.findElement(successRegisterSMS).getText();
	}
	
	
	

	

}
