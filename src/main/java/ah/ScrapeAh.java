package ah;

import java.util.*;

import ah.element.content.productgroepcontent.HeleAssortiment;
import ah.page.AhPage;
import ah.page.LeftSideBar;
import ah.page.content.AfdelingenContent;
import ah.page.content.ProductContent;
import ah.page.content.ProductGroepContent;

final class ScrapeAh {

	private static LinkedList<Integer> currentProductLane = new LinkedList<>();

	private static AhPage ahPage;
	private static LeftSideBar leftSideBar;
	private static AfdelingenContent afdelingenContent;
	private static ProductGroepContent productGroepContent;
	private static ProductContent productContent;

	public static void main(String[] args) {
		goToProductenPage();
		searchPage();
		ahPage.exit();
	}

	private static void searchPage() {
		productGroepContent = (ProductGroepContent) ahPage.getContent();
		currentProductLane.addLast(1);

		while (hasNextProductLane()) {
			handleProductLane();
			System.out.println("1");
			if (!hasNextProductLane()) {
				for (int i = 1; productGroepContent.getNthSeeMore(i).isVisible(); i++) {
					productGroepContent.getNthSeeMore(i).click();
					System.out.println("99");
					searchPage();
				}
				currentProductLane.removeLast();
				ahPage.previousPage();
				System.out.println("2");
			}
		}
	}

	private static boolean hasNextProductLane() {
		int size = productGroepContent.amountOfProductLanes();
		System.out.println("ProductLanes: " + size + " current:" + currentProductLane.getLast());
		System.out.println(currentProductLane.toString());
		return currentProductLane.getLast() <= size ? true : false;
	}

	private static void handleProductLane() {
		HeleAssortiment heleAssortiment = productGroepContent.getNthHeleAssortiment(currentProductLane.getLast());
		if (heleAssortiment.isVisible()) {
			heleAssortiment.click();
			System.out.println("3");
			currentProductLane.addLast(currentProductLane.pollLast() + 1);
			searchPage();
			System.out.println("4");
		} else {
			getAllProductsFromProductLane();
			System.out.println("5");
		}
		currentProductLane.addLast(currentProductLane.pollLast() + 1);
	}

	private static void getAllProductsFromProductLane() {
		for (int j = 1; j <= productGroepContent.amountOfProductsInProductLane(currentProductLane.getLast()); j++) {
			productGroepContent.getNthProduct(currentProductLane.getLast(), j).click();
			productContent = (ProductContent) ahPage.getContent();
			String text;
			text = productContent.getProductName().getText();
			text += " | " + productContent.getProductPrice().getText();
			text += " | " + productContent.getProductWeight().getText();
			text += " | " + productContent.getProductBonusType().getText();
			text += " | " + productContent.getProductOriginalPrice().getText();
			text += " | " + productContent.getUrl();
			System.out.println(text.replace("­", ""));
			ahPage.previousPage();
			productGroepContent = (ProductGroepContent) ahPage.getContent();
			productGroepContent.amountOfProductLanes();
		}
	}

	private static void goToProductenPage() {
		ahPage = new AhPage();
		leftSideBar = ahPage.getLeftSideBar();
		leftSideBar.getProducten().click();
		afdelingenContent = (AfdelingenContent) ahPage.getContent();
		afdelingenContent.getNthAfdeling(1).click();
	}

}
