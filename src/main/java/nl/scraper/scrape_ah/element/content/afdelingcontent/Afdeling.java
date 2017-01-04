package nl.scraper.scrape_ah.element.content.afdelingcontent;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.AnchorElement;
import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

public final class Afdeling extends AnchorElement {

	public Afdeling(WebDriver driver, AhPage page, int nth) {
		super(driver, page);
		setElement("//*[@id='productCategoryNavigation']/a[" + nth + "]");
	}

	@Override
	public ContentPage nextPageIs() {
		return ContentPage.PRODUCTGROEPPAGE;
	}

}
