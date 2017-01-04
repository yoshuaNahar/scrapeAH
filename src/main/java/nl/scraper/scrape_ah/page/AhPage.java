package nl.scraper.scrape_ah.page;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import nl.scraper.scrape_ah.page.content.Content;
import nl.scraper.scrape_ah.page.content.ContentFactory;
import nl.scraper.scrape_ah.page.content.ContentFactory.ContentPage;
import nl.scraper.scrape_ah.util.ExpectedConditions;

public final class AhPage {

	private final WebDriver driver = initWebDriver();

	private LeftSideBar leftSideBar;
	private Content content;

	public AhPage() {
		leftSideBar = new LeftSideBar(driver, this);
		setContent(ContentPage.HOMEPAGE);
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

	public void setContent(ContentPage content) {
		this.content = ContentFactory.getContent(content, driver, this);
	}

	public Content getContent() {
		return content;
	}

	public LeftSideBar getLeftSideBar() {
		return leftSideBar;
	}

	private static WebDriver initWebDriver() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.get("https://ah.nl");
		ExpectedConditions.waitTillPageLoaded();
		return driver;
	}

}
