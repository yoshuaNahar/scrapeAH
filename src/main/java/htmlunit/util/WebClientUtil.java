package htmlunit.util;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.SilentCssErrorHandler;
import com.gargoylesoftware.htmlunit.WebClient;

public final class WebClientUtil {

	private static WebClient webClient;

	private WebClientUtil() {
	}

	public static WebClient getWebClient() {
		if (webClient == null) {
			webClient = new WebClient(BrowserVersion.CHROME);
			webClient.setAjaxController(new NicelyResynchronizingAjaxController());
			webClient.setCssErrorHandler(new SilentCssErrorHandler());

			webClient.getOptions().setCssEnabled(true);
			webClient.getOptions().setRedirectEnabled(true);
			webClient.getOptions().setJavaScriptEnabled(true);
			webClient.getOptions().setPopupBlockerEnabled(true);
			webClient.getOptions().setTimeout(10000);
			webClient.getOptions().setThrowExceptionOnFailingStatusCode(true);
			webClient.getOptions().setThrowExceptionOnScriptError(true);
			webClient.getOptions().setPrintContentOnFailingStatusCode(true);
			webClient.getCookieManager().setCookiesEnabled(false);
			webClient.waitForBackgroundJavaScript(100000);
		}
		return webClient;
	}

}
