package nl.yoshuan.scraper.page.content;

import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

public abstract class Content {

    WebDriver driver;
    AhPage page;

    Content(WebDriver driver, AhPage page) {
        this.driver = driver;
        this.page = page;
    }

    public abstract ContentPage previousContent();

}
