package com.lumatest.model;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagsPage extends SideMenu {
    private WebElement drivenBackpackImage;

    private final String  productNameXpath = "//img[@alt='%s']";

    protected BagsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Click on product: ({productName} image")
    public ProductPage clickProductImage(String productName) {
        WebElement productImage = getDriver().findElement(By.xpath(String.format(productNameXpath, productName)));
        productImage.click();
        return new ProductPage(getDriver());
    }
}
