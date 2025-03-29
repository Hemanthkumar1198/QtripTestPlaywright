package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.microsoft.playwright.Page;

import pages.Adventuredetailspage;
import pages.Adventurepage;
import pages.Homepage;
import pages.Loginpage;
import pages.Registerpage;
import pages.Reservationpage;
import utils.PlaywrightManger;

public class BaseTest {

	PlaywrightManger plywrgtmngr;
	Page page;
	Loginpage login;
	Registerpage restiger;
	Homepage home;
	Adventuredetailspage adventuredetails;
	Adventurepage adventure;
	Reservationpage reservattion;

	@BeforeMethod
	public void setup() {
		plywrgtmngr = PlaywrightManger.getPlaywrightinstance();
		page = plywrgtmngr.getpage();
		page.navigate("https://qtripdynamic-qa-frontend.vercel.app/");
		page.waitForLoadState();
		login = new Loginpage(page);
		restiger = new Registerpage(page);
		home = new Homepage(page);
		adventuredetails = new Adventuredetailspage(page);
		adventure = new Adventurepage(page);
		reservattion = new Reservationpage(page);
		
	}

	@AfterMethod
	public void teardown() {
		plywrgtmngr.closeBrowser();
		PlaywrightManger.quitPlaywright();
	}

}
