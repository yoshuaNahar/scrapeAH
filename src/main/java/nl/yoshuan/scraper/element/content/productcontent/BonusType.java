package nl.yoshuan.scraper.element.content.productcontent;

import nl.yoshuan.scraper.element.TextElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public final class BonusType extends TextElement {

    private boolean visible = false;

    public BonusType(WebDriver driver) {
        super(driver);
        checkVisible();
    }

    private void checkVisible() {
        try {
            setElement("//div[@class='discount-block']/span");
            visible = true;
        } catch (NoSuchElementException e) {
            System.out.println("Inside " + BonusType.class.getSimpleName() + " exception. No bonus visible!");
        }
    }

    @Override
    public String getText() {
        if (visible) {
            return super.getText();
        }
        return "-";
    }

}
