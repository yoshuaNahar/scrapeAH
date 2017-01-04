package nl.scraper.scrape_ah.element.content.productcontent;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.TextElement;

public final class Name extends TextElement {

	public Name(WebDriver driver) {
		super(driver);
		setElement("//h1[@item-prop='name']");
	}

}
