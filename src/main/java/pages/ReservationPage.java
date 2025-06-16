package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReservationPage {

	public By menuFlights = By.linkText("Flights");
	public By oneWayRatio = By.xpath("//input[@value='oneway']");
	public By firstClassRatio = By.xpath("//input[@value='First']");
	public By departingFromDropdown = By.name("fromPort");
	public By departingOnMonth = By.name("fromMonth");
	public By departingOnDay = By.name("fromDay");
	public By arrivingInDropdown = By.name("toPort");
	public By airlineDropdown = By.name("airline");
	public By submitButton = By.xpath("//input[@type='image']");
	public By noSeatAvailableSMS = By.xpath("//b/font[contains(., 'No Seats')]");

	WebDriver driver;

	public ReservationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOn(By element) {
		driver.findElement(element).click();
	}

	public void selectOption(By element, String option) {
		WebElement dropdown = driver.findElement(element);
		Select select = new Select(dropdown);
		select.selectByVisibleText(option);
	}

	public String getMessage() {
		return driver.findElement(noSeatAvailableSMS).getText();
	}
}
