package nl.scraper.scrape_ah;

import nl.scraper.scrape_ah.element.content.searchcontent.Product;
import nl.scraper.scrape_ah.element.leftsidebar.SearchBar;
import nl.scraper.scrape_ah.page.AhPage;
import nl.scraper.scrape_ah.page.LeftSideBar;
import nl.scraper.scrape_ah.page.content.AfdelingenContent;
import nl.scraper.scrape_ah.page.content.ProductContent;
import nl.scraper.scrape_ah.page.content.ProductGroepContent;
import nl.scraper.scrape_ah.page.content.SearchContent;

public final class Demo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Yoshua Nahar//Documents//GitHub//scrapeAH//chromedriver.exe");
		new Demo();
	}

	public Demo() {
		AhPage ahPage = new AhPage();
		LeftSideBar leftSideBar = ahPage.getLeftSideBar();

		SearchBar searchBar = leftSideBar.getSearchBar();
		searchBar.insert("Cheese");
		searchBar.submit();

		SearchContent searchContent = (SearchContent) ahPage.getContent();
		Product product = searchContent.getFirstProduct();
		product.click();

		ProductContent productContent = (ProductContent) ahPage.getContent();

		ahPage.previousPage();

		ahPage.previousPage();
		leftSideBar = ahPage.getLeftSideBar();
		leftSideBar.getProducten().click();

		AfdelingenContent afdelingContent = (AfdelingenContent) ahPage.getContent();
		afdelingContent.getFirstAfdeling().click();

		ProductGroepContent productGroepContent = (ProductGroepContent) ahPage.getContent();
		productGroepContent.getNthHeleAssortiment(1).click();

		productGroepContent = (ProductGroepContent) ahPage.getContent();
		for (int i = 4; i < 8; i++) {
			String text;
			productGroepContent.getNthProduct(2, i).click();
			productContent = (ProductContent) ahPage.getContent();
			text = productContent.getProductName().getText();
			text += " | " + productContent.getProductPrice().getText();
			text += " | " + productContent.getProductWeight().getText();
			text += " | " + productContent.getProductBonusType().getText();
			text += " | " + productContent.getProductOriginalPrice().getText();
			System.out.println(text.replaceAll("­", ""));
			ahPage.previousPage();
		}

		ahPage.previousPage();

		ahPage.exit();
	}

}
