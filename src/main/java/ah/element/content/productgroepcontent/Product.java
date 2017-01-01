package ah.element.content.productgroepcontent;

import org.openqa.selenium.WebDriver;

import ah.element.AnchorElement;
import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public final class Product extends AnchorElement {

	public Product(WebDriver driver, AhPage page, int productLane, int nth) {
		super(driver, page);
		setElement("//div[contains(@class, 'lane row product-lane')][" + productLane + "]/article[" + nth + "]/a");
	}

	@Override
	public ContentPage nextPageIs() {
		return ContentPage.PRODUCTPAGE;
	}

}
