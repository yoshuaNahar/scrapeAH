package nl.yoshuan.scraper.element.content.productgroepcontent;

import nl.yoshuan.scraper.element.AnchorElement;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public final class SeeMore extends AnchorElement {

    private boolean visible = false;

    public SeeMore(WebDriver driver, AhPage page, int nth) {
        super(driver, page);
        checkVisible(nth);
    }

    public boolean isVisible() {
        return visible;
    }

    @Override
    public ContentPage nextPageIs() {
        return ContentPage.PRODUCTGROEPPAGE;
    }

    private void checkVisible(int nth) {
        try {
            setElement("//div[@class='lane row see-more-lane']/div[" + nth + "]/a");
            visible = true;
        } catch (NoSuchElementException e) {
            System.out.println("Inside: " + SeeMore.class.getSimpleName() + " exception. No see-more-button visible!");
        }
    }


}
