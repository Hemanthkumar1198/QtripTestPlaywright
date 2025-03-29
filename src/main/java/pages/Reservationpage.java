package pages;

import java.util.ArrayList;
import java.util.List;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import locators.Locators;

public class Reservationpage extends Base{

	public Reservationpage(Page page) {
		super(page);
		// TODO Auto-generated constructor stub
	}
	
	public void Reservationdata() {
		List<String> tableheaddata = new ArrayList<String>();

		Locator rowhead = page.locator(Locators.tableheadrowlocator);
		Locator column;
		for (int i = 0; i < rowhead.count(); i++) {

			column = rowhead.nth(i).locator(Locators.headcolumnlocator);
			for (int j = 1; j < column.count(); j++) {
				System.out.print(column.nth(j).innerText() + " | ");
				tableheaddata.add(column.nth(j).innerText());
			}

		}
		System.out.println();
		
		List<String> tablebodydata = new ArrayList<String>();

		Locator rowbody = page.locator(Locators.tablebodyrowlocator);
		Locator columnbody;
		if (rowbody.count() != 0) {
			for (int i = 0; i < rowbody.count(); i++) {

				columnbody = rowbody.nth(i).locator(Locators.bodycolumnlocator);
				if (columnbody.count() != 0) {
					for (int j = 0; j < columnbody.count(); j++) {
						System.out.print(columnbody.nth(j).innerText() + " | ");
						tablebodydata.add(columnbody.nth(j).innerText());
					}
				} else {
					System.out.println("null column");
				}
			}
		} else {
			System.out.println("null rowbody");
		}
		
		for(int i=0;i<tableheaddata.size();i++) {
			System.out.println(tableheaddata.get(i)+" = "+tablebodydata.get(i));
		}
		System.out.println();
	}
	
}
