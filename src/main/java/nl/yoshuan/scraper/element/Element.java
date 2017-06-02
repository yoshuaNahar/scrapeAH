package nl.yoshuan.scraper.element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Element {

    WebElement element;
    private WebDriver driver;

    Element(WebDriver driver) {
        this.driver = driver;
    }

    protected void setElement(String path) {
        element = driver.findElement(By.xpath(path));
    }

}
