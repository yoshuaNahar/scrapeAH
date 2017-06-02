package nl.yoshuan.scraper.element.content.afdelingcontent;

import nl.yoshuan.scraper.element.AnchorElement;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.WebDriver;

public final class Afdeling extends AnchorElement {

    public Afdeling(WebDriver driver, AhPage page, int nth) {
        super(driver, page);
        setElement("//*[@id='productCategoryNavigation']/a[" + nth + "]");
    }

    @Override
    public ContentPage nextPageIs() {
        return ContentPage.PRODUCTGROEPPAGE;
    }

}
