package ah.element.content.afdelingcontent;

import org.openqa.selenium.WebDriver;

import ah.element.AnchorElement;
import ah.page.AhPage;
import ah.page.content.ContentFactory.ContentPage;

public final class Afdeling extends AnchorElement {

	public Afdeling(WebDriver driver, AhPage page, int nth) {
		super(driver, page);
		setElement("//*[@id='productCategoryNavigation']/a[" + nth + "]");
	}

	@Override
	public ContentPage nextPageIs() {
		return ContentPage.PRODUCTGROEPPAGE;
	}

}
