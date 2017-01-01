package ah;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;

import ah.util.ExpectedConditions;

final class Playground {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Yoshua Nahar//Desktop//Doing Now//Udemy - Java JPA & Hibernate//Workspace//selenium//chromedriver_win32//chromedriver.exe");
		final WebDriver driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
		driver.get("https://www.ah.nl/producten/product/wi211160/ah-snoepgroente-tomaat");
		ExpectedConditions.waitTillPageLoaded();

		WebElement element = driver.findElement(ByXPath.xpath("//div[contains(@class, 'price color-black--1 bold')]"));

		WebElement elementInner = element.findElement(ByXPath.xpath("./span[1]"));
		System.out.println(elementInner.getAttribute("innerHTML"));
	}

}
