package nl.yoshuan.scraper.page.content;

import nl.yoshuan.scraper.page.AhPage;
import org.openqa.selenium.WebDriver;

public final class ContentFactory {

    public static Content getContent(ContentPage content, WebDriver driver, AhPage page) {
        switch (content) {
            case SEARCHPAGE:
                return new SearchContent(driver, page);
            case AFDELINGENPAGE:
                return new AfdelingenContent(driver, page);
            case PRODUCTGROEPPAGE:
                return new ProductGroepContent(driver, page);
            case PRODUCTPAGE:
                return new ProductContent(driver, page);
            default:
                return new HomeContent(driver, page);
        }
    }

    public enum ContentPage {
        SEARCHPAGE, AFDELINGENPAGE, PRODUCTGROEPPAGE, PRODUCTPAGE, HOMEPAGE
    }

}
