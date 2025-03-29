package pages;

import com.microsoft.playwright.Page;

import locators.Locators;

public class Loginpage extends Base {

	public Loginpage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}

	public void login() {

		page.locator(Locators.emailtextfieldlocator).waitFor();
		if (page.locator(Locators.emailtextfieldlocator).isVisible()) {
			page.locator(Locators.emailtextfieldlocator).fill(Registerpage.email);
		} else {
			System.out.println("Email field not visible!");
		}

		page.locator(Locators.pswrdfieldlocator).waitFor();
		if (page.locator(Locators.pswrdfieldlocator).isVisible()) {
			page.locator(Locators.pswrdfieldlocator).fill(Registerpage.password);
		} else {
			System.out.println("Password field not visible!");
		}
	}

	public void loinbtnclick() {
		page.locator(Locators.loginbtnlocator).click();
	}

}
