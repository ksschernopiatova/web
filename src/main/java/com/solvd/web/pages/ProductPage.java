package com.solvd.web.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'product')]//h1[contains(@class, 'title')]")
    private ExtendedWebElement name;

    @FindBy(xpath = "//*[contains(@class,'checkbox_yellow')]/input")
    private ExtendedWebElement compareCheckbox;

    @FindBy(xpath = "//*[@class='product-header']//a[contains(@class,'compare-button') and contains(@href,'compare')]/span")
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

    public String getButtonText() {
        return comparePageButton.getText();
    }
}
