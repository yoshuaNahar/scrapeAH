package nl.yoshuan.scraper.page.content;

import nl.yoshuan.scraper.element.content.searchcontent.Product;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

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
