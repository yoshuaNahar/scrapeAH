package nl.yoshuan.scraper.element.content.productgroepcontent;

import nl.yoshuan.scraper.element.AnchorElement;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

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
