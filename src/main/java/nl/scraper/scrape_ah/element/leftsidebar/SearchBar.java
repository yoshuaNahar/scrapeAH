package nl.scraper.scrape_ah.element.leftsidebar;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.SearchElement;
import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

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
