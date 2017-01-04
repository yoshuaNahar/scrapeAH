package nl.scraper.scrape_ah.element.content.productcontent;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.TextElement;

public final class Weight extends TextElement {

	public Weight(WebDriver driver) {
		super(driver);
		setElement("//h1[@item-prop='name']/following-sibling::span[2]");
	}

}
