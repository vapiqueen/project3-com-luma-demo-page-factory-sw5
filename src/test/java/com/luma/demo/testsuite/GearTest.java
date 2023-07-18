package com.luma.demo.testsuite;

import com.luma.demo.customlisteners.CustomListeners;
import com.luma.demo.pages.GearBagsPage;
import com.luma.demo.pages.HomePage;
import com.luma.demo.pages.OvernigthDufflePage;
import com.luma.demo.pages.ShoppingCartPage;
import com.luma.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class GearTest extends BaseTest {
    HomePage homePage;
    GearBagsPage gearBagsPage;
    OvernigthDufflePage overnightDufflePage;
    ShoppingCartPage shoppingCartPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        gearBagsPage = new GearBagsPage();
        overnightDufflePage = new OvernigthDufflePage();
        shoppingCartPage = new ShoppingCartPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // Hoover on gear menu
        homePage.mouseHooverToGearMenu();
        // Hoover on gear menu and click on bags
        homePage.clickOnBags();
        // Click on overnight Duffle Bag
        gearBagsPage.clickOnProductNameOvernightDuffle();
        // Verify the text name of overnight Duffle
        Assert.assertEquals(overnightDufflePage.verifyProduceName(), "Overnight Duffle");
        //Change Qty 3
        overnightDufflePage.ClearQty();
        overnightDufflePage.changeQuantity("3");
        // Click on ‘Add to Cart’ Button.
        overnightDufflePage.clickOnAddCartButton();
        //Verify the text‘You added Overnight Duffle to your shopping cart.’
        Assert.assertEquals(overnightDufflePage.verifyTheBagShoppingCartText(), "You added Overnight Duffle to your shopping cart.");
        // Click on ‘shopping cart’ Link into message
        overnightDufflePage.clickOnBagShoppingCartLink();
        //Verify the product name ‘Overnight Duffle’
        Assert.assertEquals(shoppingCartPage.verifyTheBagName(), "Overnight Duffle");
        //Verify the Qty is ‘3’
        Assert.assertEquals(shoppingCartPage.verifyTheQuantityNumber(), "3");
        //Verify the product price ‘$135.00’
        Assert.assertEquals(shoppingCartPage.verifyTheProductPriceInCart(), "$135.00");
        // Change Qty to '5'
        shoppingCartPage.clearQty();
        shoppingCartPage.changeQuantity5();
        //Click on ‘Update Shopping Cart’ button
        shoppingCartPage.clickOnUpdateShoppingCart();
        // Verify the product price ‘$225.00’
        Assert.assertEquals(shoppingCartPage.verifyTheUpdateCartPrice(), "$225.00");

    }
}
