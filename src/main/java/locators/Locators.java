package locators;

public class Locators {
	
	//homepage locators
	public static String registerbtn =".register";
	public static String reservationbtnlocator ="//a[text()='Reservations']";
	public static String searchbtnlocator = "#autocomplete";
	public static String autosuggetiolocator ="//li[text()=' Bengaluru ']";
	
	//registerpage locators
	public static String emailtextfieldlocator ="input[type='email']";
	public static String pswrdfieldlocator ="input[name='password']";
	public static String confirmpswrdfieldlocator = "input[name='confirmpassword']";
	public static String registerbtnlocator = "button[type='submit']";
	
	
	//loginpage loctors
	public static String loginbtnlocator = ".btn-login";
	
	//adventurespage locators
	public static String durationslctfilterilterlocator = "#duration-select";
	public static String categoryfilterlocator = "#category-select";
	public static String Niatownlocator = "//h5[text()='Niaboytown']";
	public static final String listoftownlocator ="//h5";
	public static String durationvalue = "2-6 Hours";
	public static String catagorievalue = "Party";
	
	//adventuredetails
	public static String namefieldlocator = "//input[@name='name']";
	public static String datefieldlocator = "//input[@name='date']";
	public static String personcountfieldlocator = "//input[@name='person']";
	public static String submitbtnlocator = "//button[@type='submit']";
	public static String successmsglocator = "[id='reserved-banner']";

	//reservationdetailspage
	public static String tableheadrowlocator = "//table[@class='table']//thead//tr";
	public static String tablebodyrowlocator = "//table[@class='table']//tbody//tr";
	public static String headcolumnlocator = "th";
	public static String bodycolumnlocator = "td";
	
	
	

}
