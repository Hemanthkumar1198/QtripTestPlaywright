package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.Configproperties;

public class Testcase extends BaseTest {

	@Test
	public void testcase01() throws InterruptedException {
		
		page.waitForLoadState();
		home.ClickRegisterbutton();
		Thread.sleep(2000);
		restiger.register();
		restiger.registerbtnclick();
		page.waitForURL("https://qtripdynamic-qa-frontend.vercel.app/pages/login/");
		Thread.sleep(2000);
		login.login();
		login.loinbtnclick();
		Thread.sleep(2000);
		
		home.Searchfunctionality(Configproperties.getProperty("cityname"));
		
		adventure.durationfilter();
		adventure.categoryfilter();
		adventure.clickontown(Configproperties.getProperty("town"));
		adventuredetails.enterdetails(Configproperties.getProperty("name"), Configproperties.getProperty("persons"));
		adventuredetails.submitbtnclick();
		
		Assert.assertEquals(adventuredetails.verifysuccessmsg().trim(),
				"Greetings! Reservation for this adventure is successful. (Click here to view your reservations)");
		
		home.ClickReservationbutton();
		reservattion.Reservationdata();
		
	}
}
