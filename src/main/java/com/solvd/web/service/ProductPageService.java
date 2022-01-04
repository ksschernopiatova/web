package com.solvd.web.service;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.web.pages.ProductPage;
import org.openqa.selenium.WebDriver;

public class ProductPageService {

    private ProductPage productPage;

    public ProductPageService(WebDriver driver) {
        this.productPage = new ProductPage(driver);
        productPage.open();
    }

    public boolean isComparePageButtonPresent() {
        return productPage.isComparePageButtonPresent();
    }

    public void compareCheckboxCheck() {
        ExtendedWebElement compareCheckbox = productPage.getCompareCheckbox();
        compareCheckbox.check();
    }

    public boolean isCompareEmpty() {
        return productPage.isCompareEmpty();
    }
}
