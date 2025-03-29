package QtrpPlaywrightTest.QtrpPlaywrightTest;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

import locators.Locators;

import com.microsoft.playwright.BrowserType.ConnectOptions;
import com.microsoft.playwright.BrowserType.ConnectOverCDPOptions;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.BrowserType.LaunchPersistentContextOptions;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Locator.FillOptions;
import com.microsoft.playwright.Page;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("Hello World!");
//		String email = "Tester" + UUID.randomUUID() + "@gmail.com";
		String timestamp = new SimpleDateFormat("ddMMyyyyHHmmss").format(new java.util.Date());
		String email ="Tester_"+timestamp+"@gmail.com";
		String password = "Password" + UUID.randomUUID();
		System.out.println("email:" + email + " *** " + "Password:" + password);

		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium()
					.launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
			BrowserContext context = browser.newContext();
			Page page = context.newPage();

			// Navigate to the application
			page.navigate("https://qtripdynamic-qa-frontend.vercel.app/");

			// Click on Register
			page.locator(".register").click();

			Thread.sleep(2000);

			// Fill registration form
			page.locator("input[type='email']").fill(email);
			page.locator("input[name='password']").fill(password);
			page.locator("input[name='confirmpassword']").fill(password);

			// Click on register button
			page.locator("button[type='submit']").click();

			// Wait for registration to complete
			Thread.sleep(2000);

			// Perform login
			page.locator("input[type='email']").fill(email);
			page.locator("input[name='password']").fill(password);
			page.locator(".btn-login").click();

			// Wait for login process
			Thread.sleep(2000);

			// Search for a city
			page.locator("#autocomplete").fill("beng");
			page.locator("//li[text()=' Bengaluru ']").click();

			// Select duration and category
			Thread.sleep(1000);
			page.locator("#duration-select").selectOption(new SelectOption().setLabel("2-6 Hours"));
			page.locator("#category-select").selectOption("Party");

			// Click on activity
			//page.locator("//h5[text()='Niaboytown']").click();
			Locator towns =page.locator("h5");
			for(int i=0; i<towns.count();i++) {
				String text = towns.nth(i).innerText();
				if(text.equalsIgnoreCase("Niaboytown")) {
					towns.nth(i).click();
					break;
				}
			}	

			page.locator("//input[@name='name']").fill("hemu");
			Thread.sleep(3000);
			try {
				page.locator("//input[@name='date']").pressSequentially("30-03-2025",
						new Locator.PressSequentiallyOptions().setDelay(150));
			} catch (Exception e) {
				// TODO: handle exception
			}
			page.locator("//input[@name='person']").fill("1");

			page.locator("//button[@type='submit']").click();

			System.out.println(page.waitForSelector(" [id='reserved-banner']").innerText());
			page.locator("//a[text()='Reservations']").click();
			
			Thread.sleep(3000);
			List<String> tableheaddata = new ArrayList<String>();

			Locator rowhead = page.locator("//table[@class='table']//thead//tr");
			Locator column;
			for (int i = 0; i < rowhead.count(); i++) {

				column = rowhead.nth(i).locator("th");
				for (int j = 1; j < column.count(); j++) {
					System.out.print(column.nth(j).innerText() + " | ");
					tableheaddata.add(column.nth(j).innerText());
				}

			}
			System.out.println();
			List<String> tablebodydata = new ArrayList<String>();

			Locator rowbody = page.locator("//table[@class='table']//tbody//tr");
			Locator columnbody;
			if (rowbody.count() != 0) {
				for (int i = 0; i < rowbody.count(); i++) {

					columnbody = rowbody.nth(i).locator("td");
					if (columnbody.count() != 0) {
						for (int j = 0; j < columnbody.count(); j++) {
							System.out.print(columnbody.nth(j).innerText() + " | ");
							tablebodydata.add(columnbody.nth(j).innerText());
						}
					} else {
						System.out.println("null");
					}
				}
			} else {
				System.out.println("null rowbody");
			}
			
			for(int i=0;i<tableheaddata.size();i++) {
				System.out.println(tableheaddata.get(i)+" "+tablebodydata.get(i));
			}
			System.out.println();
			System.out.println("Done");
////		pg.close();
//		b.close();
//		p.close();
		}
	}
}
