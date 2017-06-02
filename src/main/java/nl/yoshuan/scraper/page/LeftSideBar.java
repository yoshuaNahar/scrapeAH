package nl.yoshuan.scraper.page;

import nl.yoshuan.scraper.element.leftsidebar.Producten;
import nl.yoshuan.scraper.element.leftsidebar.SearchBar;
import org.openqa.selenium.WebDriver;

public final class LeftSideBar {

    private SearchBar searchBar;
    private Producten producten;

    LeftSideBar(WebDriver driver, AhPage page) {
        searchBar = new SearchBar(driver, page);
        producten = new Producten(driver, page);
    }

    public SearchBar getSearchBar() {
        return searchBar;
    }

    public Producten getProducten() {
        return producten;
    }

}
