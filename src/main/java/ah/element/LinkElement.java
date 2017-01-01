package ah.element;

import org.openqa.selenium.WebDriver;

import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public abstract class LinkElement extends Element {

	AhPage page;

	LinkElement(WebDriver driver, AhPage page) {
		super(driver);
		this.page = page;
	}

	protected abstract ContentPage nextPageIs();

}
