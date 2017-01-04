package nl.scraper.scrape_ah.page.content;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

public abstract class Content {

	WebDriver driver;
	AhPage page;

	Content(WebDriver driver, AhPage page) {
		this.driver = driver;
		this.page = page;
	}

	public abstract ContentPage previousContent();

}
