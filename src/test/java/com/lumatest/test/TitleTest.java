package com.lumatest.test;

import com.lumatest.base.BaseTest;
import com.lumatest.data.TestData;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import io.qameta.allure.testng.Tags;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TitleTest extends BaseTest {
    @Tags({@Tag("smoke"), @Tag("title")})
    @Story("Smoke test")
    @Severity(SeverityLevel.NORMAL)
    @Description("Smoke test for the title")
    @Owner("tester: Wera")
    @Link(TestData.BASE_URL)
    @Test
    public void testTitle() {
        Allure.step("Open the browser", () -> {
            getDriver().get(TestData.BASE_URL);
        });

        Allure.step("Create an issue with the title 'LUMA'", () -> {
            createIssue("LUMA", "This is a test issue.");
            Allure.attachment("Issue", "This is a test issue.");
        });

        Allure.step("Close the issue with the title 'LUMA'", () -> {
            closeIssue("LUMA");
        });

        Allure.step("Verify the URL and title", () -> {
            String actualUrl = getDriver().getCurrentUrl();
            String actualTitle = getDriver().getTitle();

            Allure.addAttachment("Actual URL", actualUrl);
            Allure.addAttachment("Expected URL", TestData.BASE_URL);
            Allure.addAttachment("Actual Title", actualTitle);
            Allure.addAttachment("Expected Title", "LUMA");

            Assert.assertEquals(actualUrl, TestData.BASE_URL + "/");
            Assert.assertEquals(actualTitle, TestData.BASE_URL_TITLE, "The actual title does not match the expected title");
        });
    }

    private void createIssue(String title, String body) {
        Allure.step("Send a POST request to create the issue", () -> {
            // Simulate sending a POST request to create an issue
            System.out.println("Issue created with title: " + title);
            // Add any attachments related to the request if needed
            Allure.addAttachment("Create Issue Request", "Title: " + title + "\nBody: " + body);
        });
    }

    private void closeIssue(String title) {
        Allure.step("Send a GET request to find the issue", () -> {
            // Simulate sending a GET request to find the issue
            System.out.println("Issue found with title: " + title);
            // Add any attachments related to the request if needed
            Allure.addAttachment("Find Issue Request", "Title: " + title);
        });
        Allure.step("Send a PATCH request to close the issue", () -> {
            // Simulate sending a PATCH request to close the issue
            System.out.println("Issue closed with title: " + title);
            // Add any attachments related to the request if needed
            Allure.addAttachment("Close Issue Request", "Title: " + title);
        });
    }
}

