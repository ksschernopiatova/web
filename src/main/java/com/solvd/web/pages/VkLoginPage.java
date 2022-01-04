package com.solvd.web.pages;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class VkLoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@name='email']")
    private ExtendedWebElement emailField;

    @FindBy(xpath = "//input[@name='pass']")
    private ExtendedWebElement passwordField;

    public VkLoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get("vk_url"));
    }

    public ExtendedWebElement getEmailField() {
        return emailField;
    }

    public ExtendedWebElement getPasswordField() {
        return passwordField;
    }
}
