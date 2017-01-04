package nl.scraper.scrape_ah.element.content.afdelingcontent;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.AnchorElement;
import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

public final class Product extends AnchorElement {

	public Product(WebDriver driver, AhPage page, int nth) {
		super(driver, page);
		setElement("//article[" + nth + "]/a");
	}

	@Override
	public ContentPage nextPageIs() {
		return ContentPage.PRODUCTPAGE;
	}

}
