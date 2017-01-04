package nl.scraper.scrape_ah.element;

import org.openqa.selenium.WebDriver;

public abstract class TextElement extends Element {

	protected TextElement(WebDriver driver) {
		super(driver);
	}

	public String getText() {
		// element.getText(); not working with a span
		return element.getAttribute("innerHTML");
	}

}
