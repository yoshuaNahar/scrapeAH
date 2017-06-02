package nl.yoshuan.scraper;

import nl.yoshuan.scraper.element.content.searchcontent.Product;
import nl.yoshuan.scraper.element.leftsidebar.SearchBar;
import nl.yoshuan.scraper.page.AhPage;
import nl.yoshuan.scraper.page.LeftSideBar;
import nl.yoshuan.scraper.page.content.AfdelingenContent;
import nl.yoshuan.scraper.page.content.ProductContent;
import nl.yoshuan.scraper.page.content.ProductGroepContent;
import nl.yoshuan.scraper.page.content.SearchContent;

public final class Demo {

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
        for (int i = 1; i < 4; i++) {
            productGroepContent.getNthProduct(2, i).click();
            productContent = (ProductContent) ahPage.getContent();

            StringBuilder sb = new StringBuilder();
            sb.append(productContent.getProductName().getText());
            sb.append(" | ");
            sb.append(productContent.getProductPrice().getText());
            sb.append(" | ");
            sb.append(productContent.getProductWeight().getText());
            sb.append(" | ");
            sb.append(" | ");
            sb.append(productContent.getProductBonusType().getText());
            sb.append(" | ");
            sb.append(productContent.getProductOriginalPrice().getText());
            System.out.println(sb.toString().replaceAll("\u00AD", "")); //Inside the title there are multiple dashes

            ahPage.previousPage();
        }

        ahPage.previousPage();

        ahPage.exit();
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "//home/yoshua/Documents/Git Repositories/scrapeAH/chromedriver");
        new Demo();
    }

}
