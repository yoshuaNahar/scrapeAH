package ah.page.content;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import org.openqa.selenium.By.ByXPath;

import ah.element.content.productgroepcontent.HeleAssortiment;
import ah.element.content.productgroepcontent.Product;
import ah.element.content.productgroepcontent.SeeMore;
import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public final class ProductGroepContent extends Content {

	private List<WebElement> productLanes;

	ProductGroepContent(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	public Product getFirstProduct() {
		return new Product(driver, page, 1, 1);
	}

	public Product getNthProduct(int productLane, int nth) {
		return new Product(driver, page, productLane, nth);
	}

	public HeleAssortiment getFirstHeleAssortiment() {
		return new HeleAssortiment(driver, page, 1);
	}

	public HeleAssortiment getNthHeleAssortiment(int nth) {
		return new HeleAssortiment(driver, page, nth);
	}

	public SeeMore getFirstSeeMore() {
		return new SeeMore(driver, page, 1);
	}

	public SeeMore getNthSeeMore(int nth) {
		return new SeeMore(driver, page, nth);
	}

	public int amountOfProductLanes() {
		productLanes = driver.findElements(ByXPath.xpath("//div[contains(@class, 'lane row product-lane')]"));
		return productLanes.size();
	}

	public int amountOfProductsInProductLane(int i) {
		return productLanes.get(i - 1).findElements(ByXPath.xpath("./article/a")).size();
	}

	@Override
	public ContentPage previousContent() {
		return ContentPage.PRODUCTGROEPPAGE;
	}

}
