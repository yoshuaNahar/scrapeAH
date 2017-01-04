package nl.scraper.scrape_ah.element.content.productgroepcontent;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.AnchorElement;
import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

public final class Product extends AnchorElement {

	public Product(WebDriver driver, AhPage page, int productLane, int nth) {
		super(driver, page);
		setElement("//div[contains(@class, 'lane row product-lane')][" + productLane + "]/article[" + nth + "]/a");
	}

	@Override
	public ContentPage nextPageIs() {
		return ContentPage.PRODUCTPAGE;
	}

}
