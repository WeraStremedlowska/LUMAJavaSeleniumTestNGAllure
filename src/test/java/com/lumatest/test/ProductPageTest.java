package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import com.lumatest.model.HomePage;
import com.lumatest.model.ProductPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest {

    @Test
    public void testProduct() {
        Allure.step("Open Base URL.");
        getDriver().get(TestData.BASE_URL);

        ProductPage productPage = new HomePage(getDriver())
                .clickGearLink()
                .clickBagsLink()
                .clickProductImage(TestData.DRIVEN_BACKPACK_TITLE);

        final String productTitle = productPage.getProductTitle();

        Allure.step(String.format("Verify actual: %s equals expected: %s", productTitle, TestData.DRIVEN_BACKPACK_TITLE));
        Assert.assertEquals(productTitle, TestData.DRIVEN_BACKPACK_TITLE);

    }
}
