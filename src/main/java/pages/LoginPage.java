package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
	WebDriver driver;

	private By usernameBox = By.name("userName");
	private By passwordBox = By.name("password");
	private By SubmitButton = By.name("submit");
	private By SignOnTab = By.linkText("SIGN-ON");
	private By successMessage = By.xpath("//h3[contains(text(),'Login Successfully')]");

	public LoginPage( WebDriver driver) {
		this.driver = driver;
	}

	public void inputUsername(String username) {
		driver.findElement(usernameBox).sendKeys(username);
	}
	public void inputPassword(String password) {
		driver.findElement(passwordBox).sendKeys(password);
	}
	public void clickButton() {
		driver.findElement(SubmitButton).click();
	}
	public void clickSignOn() {
		driver.findElement(SignOnTab).click();
	}
	public String getMessage() {
		return driver.findElement(successMessage).getText();
	}
	public void waitMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
	//	wait.until(ExpectedConditions.invisibilityOfElementLocated(successMessage));
	}
}
