package nl.yoshuan.scraper;

import nl.yoshuan.scraper.element.content.productgroepcontent.HeleAssortiment;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.LeftSideBar;
import nl.yoshuan.scraper.page.content.AfdelingenContent;
import nl.yoshuan.scraper.page.content.ProductContent;
import nl.yoshuan.scraper.page.content.ProductGroepContent;

import java.util.LinkedList;

public final class FullDemo {

    private LinkedList<Integer> currentProductLane = new LinkedList<>();

    private AhPage ahPage;
    private LeftSideBar leftSideBar;
    private AfdelingenContent afdelingenContent;
    private ProductGroepContent productGroepContent;
    private ProductContent productContent;

    public static void main(String[] args) {
        FullDemo ahScraper = new FullDemo();

        ahScraper.goToProductenPage();
        ahScraper.searchPage();
        ahScraper.exit();
    }

    private void goToProductenPage() {
        ahPage = new AhPage();
        leftSideBar = ahPage.getLeftSideBar();
        leftSideBar.getProducten().click();
        afdelingenContent = (AfdelingenContent) ahPage.getContent();
        afdelingenContent.getNthAfdeling(1).click();
    }

    private void searchPage() {
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

    private boolean hasNextProductLane() {
        int size = productGroepContent.amountOfProductLanes();
        System.out.println("ProductLanes: " + size + " current:" + currentProductLane.getLast());
        System.out.println(currentProductLane.toString());
        return currentProductLane.getLast() <= size;
    }

    private void handleProductLane() {
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

    private void getAllProductsFromProductLane() {
        for (int j = 1; j <= productGroepContent.amountOfProductsInProductLane(currentProductLane.getLast()); j++) {
            productGroepContent.getNthProduct(currentProductLane.getLast(), j).click();
            productContent = (ProductContent) ahPage.getContent();

            StringBuilder sb = new StringBuilder();
            sb.append(productContent.getProductName().getText().replace("�", ""));
            sb.append(" | ");
            sb.append(Double.parseDouble(productContent.getProductPrice().getText()));
            sb.append(" | ");
            String weight = productContent.getProductWeight().getText().replaceAll("[^\\d.]", "");
            if (weight.isEmpty()) {
                sb.append(1);
            } else {
                sb.append(Integer.parseInt(weight));
            }
            sb.append(" | ");
            sb.append(productContent.getProductBonusType().getText());
            sb.append(" | ");
            String bonusPrice = productContent.getProductOriginalPrice().getText(); // Not specific enough!>
            if (bonusPrice.contains("-")) {
                bonusPrice = "0";
            }
            sb.append(Double.parseDouble(bonusPrice));
            sb.append(" | ");
            sb.append(productContent.getUrl());

            System.out.println(sb.toString());

            ahPage.previousPage();
            productGroepContent = (ProductGroepContent) ahPage.getContent();
            productGroepContent.amountOfProductLanes();
        }
    }

    private void exit() {
        ahPage.exit();
    }

}
