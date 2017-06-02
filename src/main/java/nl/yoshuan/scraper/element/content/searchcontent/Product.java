package nl.yoshuan.scraper.element.content.searchcontent;

import nl.yoshuan.scraper.element.AnchorElement;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

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
