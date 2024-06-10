package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class SideMenu extends BreadcrumbsMenu {
    @FindBy(linkText = "Bags")
    private WebElement bagsLink;
    protected SideMenu(WebDriver driver) {
        super(driver);
    }

    @Step("Click on Bags link in the side menu")
    public BagsPage clickBagsLink() {
        bagsLink.click();
        return new BagsPage(getDriver());
    }
}
