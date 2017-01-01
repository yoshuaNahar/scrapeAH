package ah.element.content.productcontent;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import ah.element.TextElement;

public final class BonusType extends TextElement {

	private boolean visible = false;

	public BonusType(WebDriver driver) {
		super(driver);
		setVisible();
	}

	private void setVisible() {
		try {
			setElement("//div[@class='discount-block']/span");
			visible = true;
		} catch (NoSuchElementException e) {
			System.out.println("Inside: " + BonusType.class.getName() + " exception");
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
