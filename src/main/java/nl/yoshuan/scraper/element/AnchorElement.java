package nl.yoshuan.scraper.element;

import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.util.ExpectedConditions;
import org.openqa.selenium.WebDriver;

public abstract class AnchorElement extends LinkElement {

    protected AnchorElement(WebDriver driver, AhPage page) {
        super(driver, page);
    }

    public void click() {
        element.click();
        ExpectedConditions.waitTillPageLoaded();
        page.setContent(nextPageIs());
    }

}
