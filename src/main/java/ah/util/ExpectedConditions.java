package ah.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public final class ExpectedConditions {

	private ExpectedConditions() {
	}

	public static void waitTillPageLoaded() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static ExpectedCondition<Boolean> pageLoaded() {
		return (driver) -> execute(driver);
	}

	private static Boolean execute(WebDriver driver) {
		waitTillPageLoaded();
		return !((JavascriptExecutor) driver).executeScript("return performance.timing.loadEventEnd", new Object[0])
				.equals("0");
	}

}
