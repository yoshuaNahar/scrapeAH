package nl.scraper.scrape_ah.element;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

public abstract class LinkElement extends Element {

	AhPage page;

	LinkElement(WebDriver driver, AhPage page) {
		super(driver);
		this.page = page;
	}

	protected abstract ContentPage nextPageIs();

}
