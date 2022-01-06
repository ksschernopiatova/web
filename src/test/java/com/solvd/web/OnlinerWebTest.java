package com.solvd.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.web.components.CategoryBlock;
import com.solvd.web.components.Header;
import com.solvd.web.components.ProductBlock;
import com.solvd.web.pages.HomePage;
import com.solvd.web.pages.SearchFrame;
import com.solvd.web.pages.VkLoginPage;
import com.solvd.web.service.CatalogPageService;
import com.solvd.web.service.HomePageService;
import com.solvd.web.service.ProductPageService;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.IntStream;

public class OnlinerWebTest implements IAbstractTest {

    @DataProvider(name = "categoryItems")
    public Object[][] categoryItems() {
        return new Object[][]{
                {List.of(
                        "кошелек",
                        "люди",
                        "лайфстайл",
                        "авто",
                        "технологии",
                        "недвижимость",
                        "форум"
                )}
        };
    }

    @Test(dataProvider = "categoryItems")
    public void verifyHomePageTest(List<String> categoryItems) {
        HomePageService homePageService = new HomePageService(getDriver());
        homePageService.open();
        List<CategoryBlock> categoryBlocks = homePageService.getCategoryBlocks();

        SoftAssert sa = new SoftAssert();
        IntStream.range(0, categoryItems().length)
                .forEach(index -> sa.assertEquals(categoryBlocks.get(index).getCategoryTitle().getText().toLowerCase(),
                        categoryItems.get(index), "category isn't present"));
        sa.assertAll();
    }

    @Test
    public void verifyLogoClickTest() {
        CatalogPageService catalogPageService = new CatalogPageService(getDriver());
        catalogPageService.open();
        HomePage homePage = catalogPageService.logoClick(getDriver());
        Assert.assertTrue(homePage.getHeader().isUIObjectPresent(), "Home page was not opened");
    }

    @DataProvider(name = "searchTest")
    public Object[][] searchTest() {
        return new Object[][]{
                {"xiaomi"},
                {"google"}
        };
    }

    @Test(dataProvider = "searchTest")
    public void verifySearchTest(String text) {
        HomePageService homePageService = new HomePageService(getDriver());
        homePageService.open();
        Header header = homePageService.getHeader();

        header.searchType(text);
        SearchFrame searchFrame = homePageService.switchToSearchFrame(getDriver());
        List<ProductBlock> resultBlocks = searchFrame.getResultProducts();

        SoftAssert sa = new SoftAssert();
        resultBlocks.forEach(resultBlock -> {
            sa.assertTrue(resultBlock.getTitleText().toLowerCase().contains(text), "Search logic error");
        });
    }

    @Test
    public void verifyVkLoginTest() {
        HomePageService homePageService = new HomePageService(getDriver());
        homePageService.open();
        Header header = homePageService.getHeader();

        VkLoginPage vkLoginPage = homePageService.switchToVkLoginPage(getDriver());

        SoftAssert sa = new SoftAssert();
        sa.assertTrue(vkLoginPage.getEmailField().isPresent(10), "Login input isn't present");
        sa.assertTrue(vkLoginPage.getPasswordField().isPresent(10), "Password input isn't present");
        sa.assertAll();
    }

    @Test
    public void verifyCompareButtonTest() {
        ProductPageService productPageService = new ProductPageService(getDriver());
        productPageService.open();

        Assert.assertFalse(productPageService.isComparePageButtonPresent());
        productPageService.compareCheckboxCheck();

        Assert.assertFalse(productPageService.isCompareEmpty());
    }
}