package com.luma.demo.pages;

import com.aventstack.extentreports.Status;
import com.luma.demo.customlisteners.CustomListeners;
import com.luma.demo.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WomenPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "(//select[@id='sorter'])[1]")
    WebElement filterPrice;
    @CacheLookup
    @FindBy(xpath = "(//select[@id='sorter'])[1]")
    WebElement filterProductName;
    @CacheLookup
    @FindBy(xpath ="//strong[@class='product name product-item-name']//a" )
    WebElement jacketsNameListAfterSorting ;
    @CacheLookup
    @FindBy(xpath ="//span[@class='price-wrapper ']//span" )
    WebElement jacketsPriceListAfterSorting ;
   @CacheLookup
   @FindBy(xpath ="//span[@class='price-wrapper ']//span" ) By jacketsPriceListBeforeSorting = By.xpath("//span[@class='price-wrapper ']//span");
    @CacheLookup
    @FindBy(xpath ="//strong[@class='product name product-item-name']//a" )
    WebElement jacketsNameListBeforeSorting;


    public List<String> productListBeforeSorting() {
        Reporter.log("Jacket Name Sorting " + jacketsNameListBeforeSorting.toString());
        CustomListeners.test.log(Status.PASS, "Jacket Name Sorting" + jacketsNameListBeforeSorting);
        List<WebElement> jacketsElementsList = driver.findElements((By) jacketsNameListBeforeSorting);
        List<String> jacketsNameListBefore = new ArrayList<String>();
        for (WebElement value : jacketsElementsList) {
            jacketsNameListBefore.add(value.getText());
        }
        // Sort the before name list into Ascending Order
        jacketsNameListBefore.sort(String.CASE_INSENSITIVE_ORDER);// Ascending order
        return jacketsNameListBefore;
    }


    public List<String> productListAfterSorting() throws InterruptedException {
        Reporter.log("After Sorting Product List " + jacketsNameListAfterSorting.toString());
        CustomListeners.test.log(Status.PASS, "After Sorting Product List" + jacketsNameListAfterSorting);
        Thread.sleep(1000);
        // Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(filterProductName, "Product Name");
        Thread.sleep(1000);
        // After Sorting value
        List<WebElement> jacketsElementsList = driver.findElements((By) jacketsNameListAfterSorting);
        List<String> jacketsNameListAfter = new ArrayList<String>();
        Thread.sleep(1000);
        for (WebElement value : jacketsElementsList) {
            jacketsNameListAfter.add(value.getText());
        }

        return jacketsNameListAfter;
    }


    public List<Double> priceListBeforeSorting() {
        Reporter.log("Product Price Before Sorting " + jacketsPriceListBeforeSorting.toString());
        CustomListeners.test.log(Status.PASS, "Product price Before Sorting" + jacketsPriceListBeforeSorting);
        // Storing jackets price in list
        List<WebElement> jacketsPriceElementList = driver.findElements(jacketsPriceListBeforeSorting);
        List<Double> jacketsPriceListBefore = new ArrayList<Double>();
        for (WebElement value : jacketsPriceElementList) {
            //Converting price in to Double and Removing $ from price
            jacketsPriceListBefore.add(Double.valueOf(value.getText().replace("$", "")));
        }
        // Sort the jacketPriceListBefore to Ascending Order
        Collections.sort(jacketsPriceListBefore);
        return jacketsPriceListBefore;
    }


    public List<Double> priceListAfterSorting() throws InterruptedException {
        Reporter.log("Jacket Price After Sorting " + jacketsPriceListAfterSorting.toString());
        CustomListeners.test.log(Status.PASS, "Jacket Price After Sorting" + jacketsPriceListAfterSorting);

        // Select Sort By filter “Price”
        selectByVisibleTextFromDropDown(filterPrice, "Price");
        Thread.sleep(1000);

        // After Sorting Products by Price
        List<WebElement> jacketsPriceElementList = driver.findElements((By) jacketsPriceListAfterSorting);
        List<Double> jacketsPriceListAfter = new ArrayList<Double>();
        Thread.sleep(1000);
        for (WebElement value : jacketsPriceElementList) {
            //Converting price in to Double and Removing $ from price
            jacketsPriceListAfter.add(Double.valueOf(value.getText().replace("$", "")));
        }
        return jacketsPriceListAfter;
    }
}
