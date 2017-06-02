package nl.yoshuan.scraper.element;

import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

public abstract class LinkElement extends Element {

    AhPage page;

    LinkElement(WebDriver driver, AhPage page) {
        super(driver);
        this.page = page;
    }

    protected abstract ContentPage nextPageIs();

}
