package com.solvd.web.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(className = "catalog-masthead__title")
    private ExtendedWebElement name;

    @FindBy(xpath = "//*[@class='catalog-masthead-controls__input i-checkbox i-checkbox_yellow']/input")
    private ExtendedWebElement compareCheckbox;

    @FindBy(xpath = "//*[@class='product-header']//*[@class='compare-button__sub compare-button__sub_main']/span")
    private ExtendedWebElement comparePageButton;

    public ProductPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("product_ex_url"));
    }

    public ExtendedWebElement getProductName() {
        return name;
    }

    public ExtendedWebElement getCompareCheckbox() {
        return compareCheckbox;
    }

    public ExtendedWebElement getComparePageButton() {
        return comparePageButton;
    }

    public boolean isComparePageButtonPresent() {
        return !getDriver().findElement(By.xpath("//*[@class='product-header']//*[@class='compare-button__sub compare-button__sub_main' " +
                "and @href='https://catalog.onliner.by/compare/']")).isDisplayed();
    }

    public String getButtonText() {
        return comparePageButton.getText();
    }

    public boolean isCompareEmpty() {
        String emptyText = "0 товаров в сравнении";
        return emptyText.equalsIgnoreCase(getButtonText());
    }
}
