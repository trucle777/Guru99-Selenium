package pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegisterPage {

	private By registerTab = By.linkText("REGISTER");
	public By submitButton = By.name("submit");
	public By closePopupButton = By.xpath("//div[@class='cb-close']");
	
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
	public void clickRegisterTab() {
		driver.findElement(registerTab).click();
	}
	public void closePopupIfAny() {
		try { 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(500));
			WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(closePopupButton));
			closeButton.click();
			}
			catch(Exception e){
				System.out.println();
			}
		}
	
	public void inputText(By element, String value) {
		closePopupIfAny();
		driver.findElement(element).sendKeys(value);
	}
	
	public void clickButton(By element) {
		driver.findElement(element).click();
	}
	
	 public void selectCountry(String countryName) {
	        WebElement dropdown = driver.findElement(countryDropdown);
	        Select select = new Select(dropdown);
	        select.selectByVisibleText(countryName);
	    }
	 
	public String getSuccessRegisterSMS() {
		return driver.findElement(successRegisterSMS).getText();
	}
	
	
	}
