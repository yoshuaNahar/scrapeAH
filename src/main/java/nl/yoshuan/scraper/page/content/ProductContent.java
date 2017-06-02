package nl.yoshuan.scraper.page.content;

import nl.yoshuan.scraper.element.content.productcontent.*;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

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
