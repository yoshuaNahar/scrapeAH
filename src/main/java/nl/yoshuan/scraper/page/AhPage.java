package nl.yoshuan.scraper.page;

import nl.yoshuan.scraper.page.content.Content;
import nl.yoshuan.scraper.page.content.ContentFactory;
import nl.yoshuan.scraper.page.content.ContentFactory.ContentPage;
import nl.yoshuan.scraper.util.ExpectedConditions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class AhPage {

    private final WebDriver driver = initWebDriver();

    private LeftSideBar leftSideBar;
    private Content content;

    public AhPage() {
        leftSideBar = new LeftSideBar(driver, this);
        setContent(ContentPage.HOMEPAGE);
    }

    private static WebDriver initWebDriver() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1366, 768));
        driver.get("https://ah.nl");
        ExpectedConditions.waitTillPageLoaded();
        return driver;
    }

    public void previousPage() {
        driver.navigate().back();
        ExpectedConditions.waitTillPageLoaded();
        leftSideBar = new LeftSideBar(driver, this);
        setContent(content.previousContent());
    }

    public void exit() {
        driver.close();
    }

    public Content getContent() {
        return content;
    }

    public void setContent(ContentPage content) {
        this.content = ContentFactory.getContent(content, driver, this);
    }

    public LeftSideBar getLeftSideBar() {
        return leftSideBar;
    }

}
