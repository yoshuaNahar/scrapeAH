package htmlunit.leftsidebar;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public final class LeftSidebar {

	private final String location = "//div[@class='navigation__section-container']";
	private final HtmlElement leftSidebar;

	public LeftSidebar(HtmlPage page) {
		leftSidebar = page.getFirstByXPath(location);
	}

	public HtmlInput searchBar() {
		return leftSidebar.getFirstByXPath("//input[@name='rq']");
	}

	public HtmlAnchor products() {
		return leftSidebar.getFirstByXPath("//ul/li[1]/a");
	}

	public HtmlAnchor bonus() {
		return leftSidebar.getFirstByXPath("//ul/li[2]/a");
	}

	// ...
}
