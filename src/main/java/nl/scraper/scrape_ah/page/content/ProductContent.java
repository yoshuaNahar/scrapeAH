package nl.scraper.scrape_ah.page.content;

import org.openqa.selenium.WebDriver;

import nl.scraper.scrape_ah.element.content.productcontent.BonusType;
import nl.scraper.scrape_ah.element.content.productcontent.Name;
import nl.scraper.scrape_ah.element.content.productcontent.OriginalPrice;
import nl.scraper.scrape_ah.element.content.productcontent.Price;
import nl.scraper.scrape_ah.element.content.productcontent.Weight;
import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;

public final class ProductContent extends Content {

	ProductContent(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	public Name getProductName() {
		return new Name(driver);
	}

	public Weight getProductWeight() {
		return new Weight(driver);
	}

	public Price getProductPrice() {
		return new Price(driver);
	}

	public BonusType getProductBonusType() {
		return new BonusType(driver);
	}

	public OriginalPrice getProductOriginalPrice() {
		return new OriginalPrice(driver);
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	@Override
	public ContentPage previousContent() {
		return ContentPage.PRODUCTGROEPPAGE;
	}

}
