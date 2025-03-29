package utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightManger {

	private static PlaywrightManger instance;
	public  Playwright playwright;
	Browser browser;
	BrowserContext context;
	Page page;

	private PlaywrightManger() {
		playwright = Playwright.create();
		String browserprop = Configproperties.getProperty("browser");
		browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel(browserprop).setHeadless(false));
	}

	public static PlaywrightManger getPlaywrightinstance() {
		if (instance == null) {
			instance = new PlaywrightManger();
		}
		return instance;
	}

	public Page getpage() {
		if (page == null || page.isClosed()) {
			context = browser.newContext();
			page = context.newPage();
		}
		return page;
	}
	
	 public void closeBrowser() {
	        if (page != null) page.close();
	        if (context != null) context.close();
	    }

	    public static void quitPlaywright() {
	        if (instance != null && instance.playwright != null) {
	            instance.playwright.close();
	            instance = null;
	        }
	    }

}
