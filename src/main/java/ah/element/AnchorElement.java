package ah.element;

import org.openqa.selenium.WebDriver;

import ah.page.AhPage;
import ah.util.ExpectedConditions;

public abstract class AnchorElement extends LinkElement {

	protected AnchorElement(WebDriver driver, AhPage page) {
		super(driver, page);
	}

	public void click() {
		element.click();
		ExpectedConditions.waitTillPageLoaded();
		page.setContent(nextPageIs());
	}

}
