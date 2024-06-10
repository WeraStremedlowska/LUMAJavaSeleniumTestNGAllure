package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class TopMenu extends BasePage {
    @FindBy(linkText = "Gear")
    private WebElement gearLink;

    protected TopMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Gear link in the top menu")
    public GearPage clickGearLink() {
        gearLink.click();
        return new GearPage(getDriver());
    }
}
