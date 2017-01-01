package ah.page;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ah.page.content.Content;
import ah.page.content.ContentFactory;
import ah.page.content.ContentFactory.ContentPage;
import ah.util.ExpectedConditions;

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

	public void setContent(ContentPage content) {
		this.content = ContentFactory.getContent(content, driver, this);
	}

	public Content getContent() {
		return content;
	}

	public LeftSideBar getLeftSideBar() {
		return leftSideBar;
	}

	public void exit() {
		driver.close();
	}

	private static WebDriver initWebDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Yoshua Nahar//Desktop//Doing Now//Udemy - Java JPA & Hibernate//Workspace//selenium//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.get("https://ah.nl");
		ExpectedConditions.waitTillPageLoaded();
		return driver;
	}

}
