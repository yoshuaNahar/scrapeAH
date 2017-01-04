package nl.scraper.scrape_ah.page.content;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.content.searchcontent.Product;
import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

public final class SearchContent extends Content {

	SearchContent(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	public Product getFirstProduct() {
		return new Product(driver, page, 1);
	}

	public Product getNthProduct(int nth) {
		return new Product(driver, page, nth);
	}

	public ContentPage previousContent() {
		return ContentPage.HOMEPAGE;
	}

}
