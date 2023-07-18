package com.luma.demo.pages;

import com.aventstack.extentreports.Status;
import com.luma.demo.customlisteners.CustomListeners;
import com.luma.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class OvernigthDufflePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[@class='base']")
    WebElement verifyName;
    @FindBy(xpath = "//input[@id='qty']")
    WebElement changeNumber;
    @CacheLookup
    @FindBy(xpath = "//button[@id='product-addtocart-button']")
    WebElement clickOnButton;
    @CacheLookup
    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    WebElement verifyTextOnPage;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement cartLink;

    public String verifyProduceName() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Verify Product Name ");
        Reporter.log("Verify Product Name " + verifyName.toString());
        return getTextFromElement(verifyName);
    }

    public void changeQuantity(String quantity) throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Enter quantity  ");
        Reporter.log("Enter quantity " + quantity + " to quantity field" + changeNumber.toString());
        sendTextToElement(changeNumber, quantity);
    }

    public void clickOnAddCartButton() throws InterruptedException {
        Thread.sleep(500);
        CustomListeners.test.log(Status.PASS, "Click On Add On cart ");
        Reporter.log("Click On Add On cart " + clickOnButton.toString());
        clickOnElement(clickOnButton);
    }

    public String verifyTheBagShoppingCartText() throws InterruptedException {
        Thread.sleep(200);
        CustomListeners.test.log(Status.PASS, "Verify Shopping Cart Text");
        Reporter.log("Verify Shopping Cart Text " + verifyTextOnPage.toString());
        return getTextFromElement(verifyTextOnPage);
    }

    public void clickOnBagShoppingCartLink() {
        CustomListeners.test.log(Status.PASS, "Click On Shopping Cart Link");
        Reporter.log("Click On Shopping Cart Link " + cartLink.toString());
        clickOnElement(cartLink);
    }
    public void ClearQty(){
        driver.findElement(By.id("qty")).clear();
        Reporter.log("Clear quantity");
        CustomListeners.test.log(Status.PASS, "Clear quantity");
    }
}
