package ah.element.content.productcontent;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import ah.element.TextElement;

public final class OriginalPrice extends TextElement {

	private boolean visible = false;

	public OriginalPrice(WebDriver driver) {
		super(driver);
		setVisible();
	}

	private void setVisible() {
		try {
			setElement("//div[contains(@class, 'price--was')]/span");
			visible = true;
		} catch (NoSuchElementException e) {
			System.out.println("Inside: " + OriginalPrice.class.getName() + " exception");
		}
	}

	@Override
	public String getText() {
		if (visible) {
			return super.getText();
		}
		return "-";
	}

}
