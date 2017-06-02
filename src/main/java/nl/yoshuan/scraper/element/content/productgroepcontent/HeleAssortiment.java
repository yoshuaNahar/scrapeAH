package nl.yoshuan.scraper.element.content.productgroepcontent;

import nl.yoshuan.scraper.element.AnchorElement;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public final class HeleAssortiment extends AnchorElement {

    private boolean visible = false;

    public HeleAssortiment(WebDriver driver, AhPage page, int nth) {
        super(driver, page);
        checkVisible(nth);
    }

    @Override
    public ContentPage nextPageIs() {
        return ContentPage.PRODUCTGROEPPAGE;
    }

    private void checkVisible(int nth) {
        try {
            setElement("//div[contains(@class, 'lane row product-lane')][" + nth + "]/div/a");
            visible = true;
        } catch (NoSuchElementException e) {
            System.out.println("Inside: " + HeleAssortiment.class.getSimpleName() + " exception. No hele-assortiment-button visible!");
        }
    }

    public boolean isVisible() {
        return visible;
    }

}
