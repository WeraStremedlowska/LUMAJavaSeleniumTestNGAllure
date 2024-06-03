package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTest extends BaseTest {
    @Story("Navigation")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test navigation menu")
    @Link(TestData.BASE_URL)
    @Test(dataProvider = "navigationMenuData", dataProviderClass = TestData.class)
    public void testNavigationMenu(String baseUrl, By navMenu, String expectedUrl, String expectedTitle) {
        Allure.step("Open the browser");
        getDriver().get(baseUrl);

        Allure.step("Click on the navigation menu" + navMenu.toString());
        getDriver().findElement(navMenu).click();

        Allure.step("Verify the URL and title");
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);
        Assert.assertEquals(getDriver().getTitle(), expectedTitle);
    }
}
