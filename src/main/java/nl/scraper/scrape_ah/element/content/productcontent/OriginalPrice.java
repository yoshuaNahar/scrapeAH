package nl.scraper.scrape_ah.element.content.productcontent;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.TextElement;

public final class OriginalPrice extends TextElement {

	private boolean visible = false;

	public OriginalPrice(WebDriver driver) {
		super(driver);
		setVisible();
	}

	private void setVisible() {
		try {
			setElement("//div[contains(@class, 'price--was')]/span");
			visible = true;
		} catch (NoSuchElementException e) {
			System.out.println("Inside " + OriginalPrice.class.getSimpleName() + " exception. No original price visible!");
		}
	}

	@Override
	public String getText() {
		if (visible) {
			return super.getText();
		}
		return "-";
	}

}
