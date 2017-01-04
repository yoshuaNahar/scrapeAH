package nl.scraper.scrape_ah.element.content.productcontent;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.TextElement;

public final class BonusType extends TextElement {

	private boolean visible = false;

	public BonusType(WebDriver driver) {
		super(driver);
		checkVisible();
	}

	private void checkVisible() {
		try {
			setElement("//div[@class='discount-block']/span");
			visible = true;
		} catch (NoSuchElementException e) {
			System.out.println("Inside " + BonusType.class.getSimpleName() + " exception. No bonus visible!");
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
