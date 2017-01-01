package ah.element.content.afdelingcontent;

import org.openqa.selenium.WebDriver;

import ah.element.AnchorElement;
import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public final class Product extends AnchorElement {

	public Product(WebDriver driver, AhPage page, int nth) {
		super(driver, page);
		setElement("//article[" + nth + "]/a");
	}

	@Override
	public ContentPage nextPageIs() {
		return ContentPage.PRODUCTPAGE;
	}

}
