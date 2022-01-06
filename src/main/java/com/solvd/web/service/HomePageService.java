package com.solvd.web.service;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.solvd.web.components.CategoryBlock;
import com.solvd.web.components.Header;
import com.solvd.web.pages.CatalogPage;
import com.solvd.web.pages.HomePage;
import com.solvd.web.pages.SearchFrame;
import com.solvd.web.pages.VkLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.*;


public class HomePageService {

    private final HomePage homePage;

    public HomePageService(WebDriver driver) {
        this.homePage = new HomePage(driver);
    }

    public void open() {
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(10), "Home page was not opened");
    }

    public CatalogPage catalogPageClick(WebDriver driver) {
        Header header = homePage.getHeader();
        List<ExtendedWebElement> menu = header.getMenu();
        ExtendedWebElement catalogItem = menu.stream()
                .filter(menuItem -> "каталог".equalsIgnoreCase(menuItem.getText()))
                .findFirst().get();
        catalogItem.click();
        return new CatalogPage(driver);
    }

    public SearchFrame switchToSearchFrame(WebDriver driver) {
        SearchFrame searchFrame = new SearchFrame(driver);
        driver.switchTo().frame(driver.findElement(By.className("modal-iframe")));
        return searchFrame;
    }

    public VkLoginPage switchToVkLoginPage(WebDriver driver) {
        Header header = homePage.getHeader();
        ExtendedWebElement vkButton = header.getVkLogin();
        vkButton.click();

        VkLoginPage vkLoginPage = new VkLoginPage(driver);
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String mainWindow = driver.getWindowHandle();
        String ChildWindow;

        while (iterator.hasNext()) {
            ChildWindow = iterator.next();
            if (!mainWindow.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
            }
        }
        return vkLoginPage;
    }

    public List<CategoryBlock> getCategoryBlocks() {
        return homePage.getCategoryBlocks();
    }

    public Header getHeader() {
        return homePage.getHeader();
    }
}