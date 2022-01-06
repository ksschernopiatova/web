package com.solvd.web.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.web.components.ProductBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchFrame extends AbstractPage {

    @FindBy(xpath = "//*[contains(@class,'results')]")
    private List<ProductBlock> resultProducts;

    public SearchFrame(WebDriver driver) {
        super(driver);
    }

    public List<ProductBlock> getResultProducts() {
        return resultProducts;
    }
}
