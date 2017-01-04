package nl.scraper.scrape_ah.element;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.util.ExpectedConditions;

public abstract class AnchorElement extends LinkElement {

	protected AnchorElement(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	public void click() {
		element.click();
		ExpectedConditions.waitTillPageLoaded();
		page.setContent(nextPageIs());
	}

}
