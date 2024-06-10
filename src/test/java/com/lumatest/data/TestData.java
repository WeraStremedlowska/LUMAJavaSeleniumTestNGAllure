package com.lumatest.data;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class TestData {
    public static final String BASE_URL = "https://magento.softwaretestingboard.com";
    public static final String BASE_URL_TITLE = "Home Page";

    public static final By WHATS_NEW_MENU = By.xpath("//nav//span[text()=\"What's New\"]");
    public static final String WHATS_NEW_MENU_URL = BASE_URL + "/what-is-new.html";
    public static final String WHATS_NEW_MENU_TITLE = "What's New";

    public static final By WOMEN_MENU = By.xpath("//nav//span[text()=\"Women\"]");
    public static final String WOMEN_MENU_URL = BASE_URL + "/women.html";
    public static final String WOMEN_MENU_TITLE = "Women";

    public static final By MEN_MENU = By.xpath("//nav//span[text()=\"Men\"]");
    public static final String MEN_MENU_URL = BASE_URL + "/men.html";
    public static final String MEN_MENU_TITLE = "Men";

    public static final By GEAR_MENU = By.xpath("//nav//span[text()=\"Gear\"]");
    public static final String GEAR_MENU_URL = BASE_URL + "/gear.html";
    public static final String GEAR_MENU_TITLE = "Gear";

    public static final By TRAINING_MENU = By.xpath("//nav//span[text()=\"Training\"]");
    public static final String TRAINING_MENU_URL = BASE_URL + "/training.html";
    public static final String TRAINING_MENU_TITLE = "Training";

    public static final By SALE_MENU = By.xpath("//nav//span[text()=\"Sale\"]");
    public static final String SALE_MENU_URL = BASE_URL + "/sale.html";
    public static final String SALE_MENU_TITLE = "Sale";

    public static final String DRIVEN_BACKPACK_TITLE = "Driven Backpack";

    @DataProvider(name = "navigationMenuData")
    public static Object[][] navigationMenuData() {
        return new Object[][]{
                {BASE_URL, WHATS_NEW_MENU, WHATS_NEW_MENU_URL, WHATS_NEW_MENU_TITLE},
                {BASE_URL, WOMEN_MENU, WOMEN_MENU_URL, WOMEN_MENU_TITLE},
                {BASE_URL, MEN_MENU, MEN_MENU_URL, MEN_MENU_TITLE},
                {BASE_URL, GEAR_MENU, GEAR_MENU_URL, GEAR_MENU_TITLE},
                {BASE_URL, TRAINING_MENU, TRAINING_MENU_URL, TRAINING_MENU_TITLE},
                {BASE_URL, SALE_MENU, SALE_MENU_URL, SALE_MENU_TITLE}
        };
    }
}
