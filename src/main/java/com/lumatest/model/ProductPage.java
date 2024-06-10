package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends TopMenu {
    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    private WebElement productTitle;

    protected ProductPage(WebDriver driver) {
        super(driver);
    }

    @Step("Collect product name")
    public String getProductTitle() {
        return productTitle.getText();
    }
}
