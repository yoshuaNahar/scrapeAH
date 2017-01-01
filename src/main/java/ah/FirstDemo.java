package ah;

import ah.element.content.searchcontent.Product;
import ah.element.leftsidebar.SearchBar;
import ah.page.AhPage;
import ah.page.LeftSideBar;
import ah.page.content.AfdelingenContent;
import ah.page.content.ProductContent;
import ah.page.content.ProductGroepContent;
import ah.page.content.SearchContent;

final class FirstDemo {

	public static void main(String[] args) {
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
