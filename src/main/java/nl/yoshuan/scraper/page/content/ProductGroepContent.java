package nl.yoshuan.scraper.page.content;

import nl.yoshuan.scraper.element.content.productgroepcontent.HeleAssortiment;
import nl.yoshuan.scraper.element.content.productgroepcontent.Product;
import nl.yoshuan.scraper.element.content.productgroepcontent.SeeMore;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public final class ProductGroepContent extends Content {

    private List<WebElement> productLanes;

    ProductGroepContent(WebDriver driver, AhPage page) {
        super(driver, page);
    }

    public int amountOfProductLanes() {
        productLanes = driver.findElements(ByXPath.xpath("//div[contains(@class, 'lane row product-lane')]"));
        return productLanes.size();
    }

    public int amountOfProductsInProductLane(int i) {
        return productLanes.get(i - 1).findElements(ByXPath.xpath("./article/a")).size();
    }

    public Product getFirstProduct() {
        return new Product(driver, page, 1, 1);
    }

    public Product getNthProduct(int productLane, int nth) {
        return new Product(driver, page, productLane, nth);
    }

    public HeleAssortiment getFirstHeleAssortiment() {
        return new HeleAssortiment(driver, page, 1);
    }

    public HeleAssortiment getNthHeleAssortiment(int nth) {
        return new HeleAssortiment(driver, page, nth);
    }

    public SeeMore getFirstSeeMore() {
        return new SeeMore(driver, page, 1);
    }

    public SeeMore getNthSeeMore(int nth) {
        return new SeeMore(driver, page, nth);
    }

    @Override
    public ContentPage previousContent() {
        return ContentPage.PRODUCTGROEPPAGE;
    }

}
