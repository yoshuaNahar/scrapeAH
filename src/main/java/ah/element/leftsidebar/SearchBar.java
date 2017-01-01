package ah.element.leftsidebar;

import org.openqa.selenium.WebDriver;

import ah.element.SearchElement;
import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public final class SearchBar extends SearchElement {

	public SearchBar(WebDriver driver, AhPage page) {
		super(driver, page);
		setElement("//input[@name='rq']");
	}

	@Override
	public ContentPage nextPageIs() {
		return ContentPage.SEARCHPAGE;
	}

}
