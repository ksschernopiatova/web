package com.solvd.web.service;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.web.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductPageService {

    private final ProductPage productPage;

    public ProductPageService(WebDriver driver) {
        this.productPage = new ProductPage(driver);
    }

    public void open() {
        productPage.open();
        Assert.assertTrue(productPage.isPageOpened(10), "Product page was not opened");
    }

    public boolean isComparePageButtonPresent() {
        return !productPage.getDriver().findElement(By.xpath("//*[@class='product-header']//a[contains(@class,'compare-button') and " +
                "@href='https://catalog.onliner.by/compare/']")).isDisplayed();
    }

    public void compareCheckboxCheck() {
        ExtendedWebElement compareCheckbox = productPage.getCompareCheckbox();
        compareCheckbox.check();
    }

    public boolean isCompareEmpty() {
        String emptyText = "0 товаров в сравнении";
        return emptyText.equalsIgnoreCase(productPage.getButtonText());
    }
}
