package ah.page.content;

import org.openqa.selenium.WebDriver;

import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public final class HomeContent extends Content {

	HomeContent(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	@Override
	public ContentPage previousContent() {
		throw new RuntimeException("Previous Content Not Available");
	}

}
