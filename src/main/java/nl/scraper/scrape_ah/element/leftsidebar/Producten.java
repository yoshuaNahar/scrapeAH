package nl.scraper.scrape_ah.element.leftsidebar;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.AnchorElement;
import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

public final class Producten extends AnchorElement {

	public Producten(WebDriver driver, AhPage page) {
		super(driver, page);
		setElement("//*[@id='mCSB_1_container']/div/nav[1]/ul/li[1]/a");
	}

	@Override
	public ContentPage nextPageIs() {
		return ContentPage.AFDELINGENPAGE;
	}

}
