package com.solvd.web.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductBlock extends AbstractUIObject {

    @FindBy(className = "product__title")
    private ExtendedWebElement productTitle;

    @FindBy(className = "product__description")
    private ExtendedWebElement productDescription;

    public ProductBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getProductTitle() {
        return productTitle;
    }

    public String getTitleText() {
        return productTitle.getText();
    }

    public ExtendedWebElement getProductDescription() {
        return productDescription;
    }
}
