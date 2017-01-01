package ah.element.content.productgroepcontent;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import ah.element.AnchorElement;
import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public final class HeleAssortiment extends AnchorElement {

	private boolean visible = false;

	public HeleAssortiment(WebDriver driver, AhPage page, int nth) {
		super(driver, page);
		setVisible(nth);
	}

	@Override
	public ContentPage nextPageIs() {
		return ContentPage.PRODUCTGROEPPAGE;
	}

	private void setVisible(int nth) {
		try {
			setElement("//div[contains(@class, 'lane row product-lane')][" + nth + "]/div/a");
			visible = true;
		} catch (NoSuchElementException e) {
			System.out.println("Inside: " + HeleAssortiment.class.getName() + " exception");
		}
	}

	public boolean isVisible() {
		return visible;
	}

}
