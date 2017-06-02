package nl.yoshuan.scraper.element.leftsidebar;

import nl.yoshuan.scraper.element.AnchorElement;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

public final class Producten extends AnchorElement {

    public Producten(WebDriver driver, AhPage page) {
        super(driver, page);
        setElement("//*[@id='mCSB_1_container']/div/nav[1]/ul/li[1]/a");
    }

    @Override
    public ContentPage nextPageIs() {
        return ContentPage.AFDELINGENPAGE;
    }

}
