package ah.page.content;

import org.openqa.selenium.WebDriver;

import ah.element.content.searchcontent.Product;
import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public final class SearchContent extends Content {

	SearchContent(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	public Product getFirstProduct() {
		return new Product(driver, page, 1);
	}

	public Product getNthProduct(int nth) {
		return new Product(driver, page, nth);
	}

	public ContentPage previousContent() {
		return ContentPage.HOMEPAGE;
	}

}
