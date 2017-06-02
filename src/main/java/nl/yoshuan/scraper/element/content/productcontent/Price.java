package nl.yoshuan.scraper.element.content.productcontent;

import nl.yoshuan.scraper.element.TextElement;
import org.openqa.selenium.WebDriver;

public final class Price extends TextElement {

    public Price(WebDriver driver) {
        super(driver);
        setElement("//div[contains(@class, 'price color-black--1 bold')]");
    }

    @Override
    public String getText() {
        String price;
        setElement("//div[contains(@class, 'price color-black--1 bold')]/span[1]");
        price = super.getText();
        setElement("//div[contains(@class, 'price color-black--1 bold')]/span[2]");
        price += super.getText();
        setElement("//div[contains(@class, 'price color-black--1 bold')]/span[3]");
        price += super.getText();
        return price;
    }

}
