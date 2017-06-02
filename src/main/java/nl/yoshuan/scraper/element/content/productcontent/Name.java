package nl.yoshuan.scraper.element.content.productcontent;

import nl.yoshuan.scraper.element.TextElement;
import org.openqa.selenium.WebDriver;

public final class Name extends TextElement {

    public Name(WebDriver driver) {
        super(driver);
        setElement("//h1[@item-prop='name']");
    }

}
