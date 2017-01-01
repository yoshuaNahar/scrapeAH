package ah.element;

import org.openqa.selenium.WebDriver;

import ah.page.AhPage;
import ah.util.ExpectedConditions;

public abstract class SearchElement extends LinkElement {

	protected SearchElement(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	public void insert(String string) {
		element.sendKeys(string);
	}

	public void submit() {
		element.submit();
		ExpectedConditions.waitTillPageLoaded();
		page.setContent(nextPageIs());
	}

}
