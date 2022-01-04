package com.solvd.web.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.web.components.CategoryBlock;
import com.solvd.web.components.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    @FindBy(className = "g-top")
    private Header header;

    @FindBy(xpath = "//*[@class='b-main-page-grid-4 b-main-page-news-2']")
    private List<CategoryBlock> categoryBlocks;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("home_url"));
    }

    public Header getHeader() {
        return header;
    }

    public List<CategoryBlock> getCategoryBlocks() {
        return categoryBlocks;
    }
}