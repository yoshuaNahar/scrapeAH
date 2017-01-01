package stackanswer;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;

final class Problem {

	private static HtmlPage page;

	public static void main(String[] args) {
		final WebClient wc;
		try {
			wc = new WebClient();
			page = wc.getPage("http://google.com/");

			HtmlInput searchForm = page.getFirstByXPath("//input[@name='q']");
			System.out.println(searchForm.asXml());
			searchForm.setValueAttribute("q");

			HtmlSubmitInput submitButton = page.getFirstByXPath("//input[@name='btnK']");
			System.out.println(submitButton.asXml());
			page = submitButton.click();

			System.out.println(page.getUrl().toString());
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		}
	}

}
