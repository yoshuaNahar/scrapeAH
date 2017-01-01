package htmlunit;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import htmlunit.leftsidebar.LeftSidebar;
import htmlunit.util.WebClientUtil;

final class HtmlUnitExample {

	private static HtmlPage page;

	public static void main(String[] args) throws IOException {
		final WebClient webClient = WebClientUtil.getWebClient();

		try {
			page = webClient.getPage("https://www.ah.nl");
		} catch (FailingHttpStatusCodeException | IOException e) {
			e.printStackTrace();
		}

		LeftSidebar leftSidebar = new LeftSidebar(page);
		page = leftSidebar.products().click();

		System.out.println(page.asText());
		System.out.println(page.getBaseURL());

		HtmlAnchor anchor = page.getAnchorByHref("/producten/aardappel-groente-fruit");
		System.out.println(anchor.getHrefAttribute());
	}
}
