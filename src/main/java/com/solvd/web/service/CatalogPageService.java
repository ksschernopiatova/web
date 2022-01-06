package com.solvd.web.service;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.web.pages.CatalogPage;
import com.solvd.web.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CatalogPageService {

    private final CatalogPage catalogPage;

    public CatalogPageService(WebDriver driver) {
        this.catalogPage = new CatalogPage(driver);
    }

    public void open() {
        catalogPage.open();
        Assert.assertTrue(catalogPage.isPageOpened(10), "Catalog page was not opened");
    }

    public HomePage logoClick(WebDriver driver) {
        ExtendedWebElement logo = catalogPage.getHeader().getLogo();
        logo.click();
        return new HomePage(driver);
    }
}
