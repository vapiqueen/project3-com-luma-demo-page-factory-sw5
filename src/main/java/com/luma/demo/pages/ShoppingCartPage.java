package com.luma.demo.pages;

import com.aventstack.extentreports.Status;
import com.luma.demo.customlisteners.CustomListeners;
import com.luma.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[@class='base']")
    WebElement verifyText;
    @CacheLookup
    @FindBy(xpath = "//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']")
    WebElement verifyName;
    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'32')]")
    WebElement verifySize;
    @CacheLookup
    @FindBy(xpath = "//dd[contains(text(),'Black')]")
    WebElement verifyColour;
    @CacheLookup
    @FindBy(xpath = "//td[@class='col item']//a[normalize-space()='Overnight Duffle']")
    WebElement verifyBagName;
    @CacheLookup
    @FindBy(xpath = "//input[@title='Qty']")
    WebElement verifyQty;
    @CacheLookup
    @FindBy(xpath = "//span[@class='cart-price']//span[@class='price'][normalize-space()='$135.00']")
    WebElement verifyThePrice;
    @CacheLookup
    @FindBy(xpath = "//input[@title='Qty']")
    WebElement changeQty;
    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='Update Shopping Cart']")
    WebElement clickUpdate;
    @CacheLookup
    @FindBy(xpath = "(//span[@class='cart-price']//span)[2]")
    WebElement verifyLastPrice;

    public String verifyTextMessage() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Verify Text Message");
        Reporter.log("Verify Text Message " + verifyText.toString());
        return getTextFromElement(verifyText);
    }

    public String verifyProductName() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Verify Product Name ");
        Reporter.log("Verify Product Name " + verifyName.toString());
        return getTextFromElement(verifyName);
    }

    public String verifyProductSize() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "erify Product Size ");
        Reporter.log("Verify Product Size " + verifySize.toString());
        return getTextFromElement(verifySize);
    }

    public String verifyProductColour() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Verify Product Colour");
        Reporter.log("Verify Product Colour " + verifyColour.toString());
        return getTextFromElement(verifyColour);
    }

    public String verifyTheBagName() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Verify Product Bag Name ");
        Reporter.log("Verify Product Bag Name " + verifyBagName.toString());
        return getTextFromElement(verifyBagName);
    }

    public String verifyTheQuantityNumber() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Verify Product Quantity");
        Reporter.log("Verify Product Quantity " + verifyQty.toString());
        return getAttributeValueFromElement(verifyQty);
    }

    public String verifyTheProductPriceInCart() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Verify Product Price In Cart");
        Reporter.log("Verify Product Price In Cart" + verifyThePrice.toString());
        return getTextFromElement(verifyThePrice);
    }

    public void changeQuantity5() throws InterruptedException {
        Thread.sleep(1000);
        CustomListeners.test.log(Status.PASS, "Change Quantity");
        Reporter.log("Change Quantity" + changeQty.toString());
        sendTextToElement(changeQty, "5");
    }

    public void clickOnUpdateShoppingCart() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Click On Update shopping Cart");
        Reporter.log("Click On Update shopping Cart" + clickUpdate.toString());
        clickOnElement(clickUpdate);
    }

    public String verifyTheUpdateCartPrice() throws InterruptedException {
        Thread.sleep(1000);
        CustomListeners.test.log(Status.PASS, "Verify The Update CartPrice");
        Reporter.log("Verify The Update CartPrice" + verifyLastPrice.toString());
        return getTextFromElement(verifyLastPrice);

    }
    public void clearQty() {
        Reporter.log("Clear quantity");
        CustomListeners.test.log(Status.PASS, "Clear quantity");
        driver.findElement(By.xpath("//body[1]/div[1]/main[1]/div[3]/div[1]/div[2]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/label[1]/input[1]")).clear();
    }

}
