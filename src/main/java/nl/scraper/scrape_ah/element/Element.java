package nl.scraper.scrape_ah.element;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.By;

public abstract class Element {

	private WebDriver driver;
	WebElement element;

	Element(WebDriver driver) {
		this.driver = driver;
	}

	protected void setElement(String path) {
		element = driver.findElement(By.xpath(path));
	}

}
