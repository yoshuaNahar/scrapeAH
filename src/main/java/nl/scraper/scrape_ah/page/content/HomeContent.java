package nl.scraper.scrape_ah.page.content;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

public final class HomeContent extends Content {

	HomeContent(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	@Override
	public ContentPage previousContent() {
		throw new RuntimeException("Previous Content Not Available");
	}

}
