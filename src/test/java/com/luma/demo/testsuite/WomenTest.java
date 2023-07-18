package com.luma.demo.testsuite;

import com.luma.demo.customlisteners.CustomListeners;
import com.luma.demo.pages.HomePage;
import com.luma.demo.pages.WomenPage;
import com.luma.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class WomenTest extends BaseTest {
    HomePage homePage;
    WomenPage womenPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        womenPage = new WomenPage();
    }

    @Test(groups = {"sanity","regression"})
    public void verifyTheSortByProductNameFilter() throws InterruptedException {

        //Mouse Hover on Women Menu
        homePage.mouserHooverToWomenMenu();
        //Mouse Hover on Tops
        homePage.mouseHooverToTopMenu();
        //Click on Jackets
        homePage.clickOnJacket();

        //Assert.assertEquals(womenPage.productListAfterSorting(),womenPage.productListBeforeSorting());
    }
    @Test(groups = {"smoke", "regression"})

    public void verifyTheSortByPriceFilter() throws InterruptedException {
        Thread.sleep(1000);
        //Mouse Hover on Women Menu
        homePage.mouserHooverToWomenMenu();
        //Mouse Hover on Tops
        homePage.mouseHooverToTopMenu();
        //Click on Jackets
        homePage.clickOnJacket();

        //Assert.assertEquals(womenPage.priceListAfterSorting(),womenPage.priceListBeforeSorting());

    }
}
