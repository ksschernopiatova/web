package com.solvd.web.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.solvd.web.pages.CatalogPage;
import com.solvd.web.pages.HomePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Header extends AbstractUIObject {

    @FindBy(xpath = ".//*[contains(@class,'main-navigation__item')]/a/span")
    private List<ExtendedWebElement> menu;

    @FindBy(xpath = ".//input[contains(@class,'search__input')]")
    private ExtendedWebElement searchField;

    @FindBy(xpath = ".//*[contains(@class,'top-logo')]")
    private ExtendedWebElement logo;

    @FindBy(xpath = ".//*[@title='ВКонтакте']")
    private ExtendedWebElement vkLogin;

    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void searchType(String text) {
        this.getSearchField().type(text);
    }

    public CatalogPage catalogClick() {
        CatalogPage catalogPage = new CatalogPage(driver);
        for(ExtendedWebElement menuItem : menu) {
            if("каталог".equalsIgnoreCase(menuItem.getText())) {
                menuItem.click();
            }
        }
        return catalogPage;
    }

    public HomePage logoClick() {
        HomePage homePage = new HomePage(driver);
        if (logo.isElementPresent()) {
            logo.click();
        }
        return homePage;
    }

    public List<ExtendedWebElement> getMenu() {
        return menu;
    }

    public ExtendedWebElement getSearchField() {
        return searchField;
    }

    public ExtendedWebElement getLogo() {
        return logo;
    }

    public ExtendedWebElement getVkLogin() {
        return vkLogin;
    }
}
