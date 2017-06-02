package nl.yoshuan.scraper.element;

import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.util.ExpectedConditions;
import org.openqa.selenium.WebDriver;

public abstract class SearchElement extends LinkElement {

    protected SearchElement(WebDriver driver, AhPage page) {
        super(driver, page);
    }

    public void insert(String string) {
        element.sendKeys(string);
    }

    public void submit() {
        element.submit();
        ExpectedConditions.waitTillPageLoaded();
        page.setContent(nextPageIs());
    }

}
