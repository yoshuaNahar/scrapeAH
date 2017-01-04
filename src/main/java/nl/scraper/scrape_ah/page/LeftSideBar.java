package nl.scraper.scrape_ah.page;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.leftsidebar.Producten;
import nl.scraper.scrape_ah.element.leftsidebar.SearchBar;

public final class LeftSideBar {

	private SearchBar searchBar;
	private Producten producten;

	LeftSideBar(WebDriver driver, AhPage page) {
		searchBar = new SearchBar(driver, page);
		producten = new Producten(driver, page);
	}

	public SearchBar getSearchBar() {
		return searchBar;
	}

	public Producten getProducten() {
		return producten;
	}

}
