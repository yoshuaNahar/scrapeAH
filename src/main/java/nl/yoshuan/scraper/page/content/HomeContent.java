package nl.yoshuan.scraper.page.content;

import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

public final class HomeContent extends Content {

    HomeContent(WebDriver driver, AhPage page) {
        super(driver, page);
    }

    @Override
    public ContentPage previousContent() {
        throw new RuntimeException("Previous Content Not Available");
    }

}
