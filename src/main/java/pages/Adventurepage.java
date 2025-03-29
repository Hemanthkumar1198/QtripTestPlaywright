package pages;

import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import locators.Locators;

public class Adventurepage extends Base{

	public Adventurepage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}
	
	public void durationfilter() {
		page.locator(Locators.durationslctfilterilterlocator).selectOption(new SelectOption().setLabel(Locators.durationvalue));
	}
	
	public void categoryfilter() {
		page.locator(Locators.categoryfilterlocator).selectOption(Locators.catagorievalue);
	}
	
	public void clickontown(String town) {
		Locator towns =page.locator(Locators.listoftownlocator);
		for(int i=0; i<towns.count();i++) {
			String text = towns.nth(i).innerText();
			if(text.equalsIgnoreCase(town)) {
				towns.nth(i).click();
			}
		}	
		//page.locator(Locators.Niatownlocator).click();
	}
}
