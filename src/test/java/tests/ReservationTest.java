package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.ReservationPage;

public class ReservationTest {
	WebDriver driver;
	ReservationPage reservation;

//Pre-condition: Navigate to https://demo.guru99.com/test/newtours/
	@Before
	public void setUp() {
		System.setProperty("webDriver.chrome.driver", System.getProperty("user.home") + "/selenium/tools/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/");
		reservation = new ReservationPage(driver);
	}

	@Test
	// Verify flight search returns 'No Seats Available' when no flights are found
	public void testSearchFlights() {

		// Click on "Flights" on the left menu
		reservation.clickOn(reservation.menuFlights);

		// Select “Round Trip”
		reservation.clickOn(reservation.oneWayRatio);

		// Choose: Depart from: Paris
		reservation.selectOption(reservation.departingFromDropdown, "Paris");

		// Choose: Arrive at: New York
		reservation.selectOption(reservation.arrivingInDropdown, "New York");

		// Choose date: August 01
		reservation.selectOption(reservation.departingOnMonth, "August");

		// Choose Economy class
		reservation.clickOn(reservation.firstClassRatio);

		// Choose Airline
		reservation.selectOption(reservation.airlineDropdown, "Blue Skies Airlines");

		// Click CONTINUE
		reservation.clickOn(reservation.submitButton);

		// Check if the message "No Seats Available" is displayed
		// NOTE: "Avaialble" is a typo in the actual page message
		String expectSMS = "After flight finder - No Seats Available";
		String actualSMS = reservation.getMessage();

		System.out.println("The expected SMS required is: " + expectSMS);
		System.err.println("The actual SMS displayed is: " + actualSMS);
		Assert.assertTrue("Expected SMS to contain:" + expectSMS, actualSMS.contains(expectSMS));
	}

	@After
	public void closeBrowser() {
		if (driver != null) {
			driver.quit();
		}
	}

}
