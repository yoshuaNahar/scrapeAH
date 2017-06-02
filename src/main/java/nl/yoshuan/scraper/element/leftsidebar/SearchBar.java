package nl.yoshuan.scraper.element.leftsidebar;

import nl.yoshuan.scraper.element.SearchElement;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

public final class SearchBar extends SearchElement {

    public SearchBar(WebDriver driver, AhPage page) {
        super(driver, page);
        setElement("//input[@name='rq']");
    }

    @Override
    public ContentPage nextPageIs() {
        return ContentPage.SEARCHPAGE;
    }

}
