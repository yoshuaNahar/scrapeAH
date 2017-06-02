package nl.yoshuan.scraper.element.content.productcontent;

import nl.yoshuan.scraper.element.TextElement;
import org.openqa.selenium.WebDriver;

public final class Weight extends TextElement {

    public Weight(WebDriver driver) {
        super(driver);
        setElement("//h1[@item-prop='name']/following-sibling::span[2]");
    }

}
