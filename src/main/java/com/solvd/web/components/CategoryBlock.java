package com.solvd.web.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CategoryBlock extends AbstractUIObject {

    @FindBy(xpath = "./header/h2/a")
    private ExtendedWebElement title;

    public CategoryBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public ExtendedWebElement getCategoryTitle() {
        return title;
    }
}
