package pages;

import com.microsoft.playwright.Page;

import locators.Locators;

public class Homepage extends Base{

	public Homepage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}
	
	public void ClickRegisterbutton() {
		page.locator(Locators.registerbtn).click();
	}
	
	public void ClickReservationbutton() {
		page.locator(Locators.reservationbtnlocator).click();
	}
	
	public void Searchfunctionality(String city) {
		page.locator(Locators.searchbtnlocator).fill(city);
		page.locator(Locators.autosuggetiolocator).click();
	}
	

}
