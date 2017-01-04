package nl.scraper.scrape_ah.element;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.util.ExpectedConditions;

public abstract class SearchElement extends LinkElement {

	protected SearchElement(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	public void insert(String string) {
		element.sendKeys(string);
	}

	public void submit() {
		element.submit();
		ExpectedConditions.waitTillPageLoaded();
		page.setContent(nextPageIs());
	}

}
