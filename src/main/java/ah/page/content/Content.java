package ah.page.content;

import org.openqa.selenium.WebDriver;

import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public abstract class Content {

	WebDriver driver;
	AhPage page;

	Content(WebDriver driver, AhPage page) {
		this.driver = driver;
		this.page = page;
	}

	public abstract ContentPage previousContent();

}
