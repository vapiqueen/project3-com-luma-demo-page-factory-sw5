package com.luma.demo.pages;

import com.aventstack.extentreports.Status;
import com.luma.demo.customlisteners.CustomListeners;
import com.luma.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class GearBagsPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Overnight Duffle']")
    WebElement overNightDuffle;

    public void clickOnProductNameOvernightDuffle() throws InterruptedException {
        CustomListeners.test.log(Status.PASS, "Click On OvernightDuffle ");
        Reporter.log("Click On OvernightDuffle  " + overNightDuffle.toString());
        Thread.sleep(500);
        clickOnElement(overNightDuffle);
    }
}
