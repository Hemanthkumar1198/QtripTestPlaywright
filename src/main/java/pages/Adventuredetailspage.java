package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import locators.Locators;

public class Adventuredetailspage extends Base {

	public Adventuredetailspage(Page page) {
		super(page);
	}
	
	 public static String getTomorrowDate(String format) {
	        LocalDate tomorrow = LocalDate.now().plusDays(1);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
	        return tomorrow.format(formatter);
	    }
	 

	public void enterdetails(String name, String personcount) {
		String date = getTomorrowDate("dd-MM-yyyy");
		page.locator(Locators.namefieldlocator).fill(name);
		page.locator(Locators.personcountfieldlocator).fill(personcount);
		page.locator(Locators.datefieldlocator).pressSequentially(date,
				new Locator.PressSequentiallyOptions().setDelay(100));
	}

	public void submitbtnclick() {
		page.locator(Locators.submitbtnlocator).click();
	}
	
	public String verifysuccessmsg() {
		String text = page.locator(Locators.successmsglocator).innerText();
		if(text!= null) 
			System.out.println("Successfully placed reservation");;
		return text;		
	}

}
