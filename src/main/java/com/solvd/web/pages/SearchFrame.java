package com.solvd.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.web.components.ProductBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchFrame extends AbstractPage {

    @FindBy(className = "search__tabs-item")
    private List<ExtendedWebElement> searchTabs;

    @FindBy(className = "search__result")
    private List<ProductBlock> resultProducts;

    public SearchFrame(WebDriver driver) {
        super(driver);
    }

    public List<ExtendedWebElement> getSearchTabs() {
        return searchTabs;
    }

    public List<ProductBlock> getResultProducts() {
        return resultProducts;
    }
}
