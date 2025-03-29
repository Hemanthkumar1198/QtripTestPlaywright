package pages;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.UUID;

import com.microsoft.playwright.Page;

import locators.Locators;

public class Registerpage extends Base {
	
	public static String timestamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new java.util.Date());
	public static String email ="Tester_"+timestamp+"@gmail.com";
	public static String password = "Pass"+UUID.randomUUID();

	public Registerpage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public void register() {
		page.waitForLoadState();
		page.locator(Locators.emailtextfieldlocator).waitFor();
		page.locator(Locators.emailtextfieldlocator).fill(email);
		page.locator(Locators.pswrdfieldlocator).fill(password);
		page.locator(Locators.confirmpswrdfieldlocator).fill(password);
	}
	
	public void registerbtnclick() {
		page.locator(Locators.registerbtnlocator).click();
		
	}

}
