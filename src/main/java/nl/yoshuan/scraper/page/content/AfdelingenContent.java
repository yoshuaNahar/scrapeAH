package nl.yoshuan.scraper.page.content;

import nl.yoshuan.scraper.element.content.afdelingcontent.Afdeling;
import nl.yoshuan.scraper.element.content.afdelingcontent.Product;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

public final class AfdelingenContent extends Content {

    public static final int AANTAL_AFDELINGEN = 18;

    AfdelingenContent(WebDriver driver, AhPage page) {
        super(driver, page);
    }

    public Afdeling getFirstAfdeling() {
        return new Afdeling(driver, page, 1);
    }

    public Afdeling getNthAfdeling(int nth) {
        return new Afdeling(driver, page, nth);
    }

    public Product getFirstProduct() {
        return new Product(driver, page, 1);
    }

    public Product getNthProduct(int nth) {
        return new Product(driver, page, nth);
    }

    @Override
    public ContentPage previousContent() {
        return ContentPage.HOMEPAGE;
    }

}
