package nl.scraper.scrape_ah.page.content;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.page.AhPage;

public final class ContentFactory {

	public enum ContentPage {
		SEARCHPAGE, AFDELINGENPAGE, PRODUCTGROEPPAGE, PRODUCTPAGE, HOMEPAGE
	}

	public static Content getContent(ContentPage content, WebDriver driver, AhPage page) {
		switch (content) {
		case SEARCHPAGE:
			return new SearchContent(driver, page);
		case AFDELINGENPAGE:
			return new AfdelingenContent(driver, page);
		case PRODUCTGROEPPAGE:
			return new ProductGroepContent(driver, page);
		case PRODUCTPAGE:
			return new ProductContent(driver, page);
		default:
			return new HomeContent(driver, page);
		}
	}

}
