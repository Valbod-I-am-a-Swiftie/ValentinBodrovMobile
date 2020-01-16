package hw2.webApp;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import hw2.pages.webApp.SearchPage;
import hw2.pages.webApp.SearchResultPage;
import hw2.setup.DriverSetup;

import java.io.IOException;

import static org.testng.Assert.assertFalse;

/**
 * This test class describes the test of a web
 * application with searching in Google.com
 */
public class WebAppTest extends DriverSetup {

    private SearchPage searchPage;
    private SearchResultPage searchResultPage;

    private String TEST_SEARCH_PHRASE;

    public WebAppTest() throws IOException {
    }

    @Test(groups = {"web"})
    public void webAppTest() throws Exception {
        TEST_SEARCH_PHRASE = getProp("test_search_phrase");

        this.searchPage = new SearchPage(driver());
        this.searchResultPage = new SearchResultPage(driver());

        // Going to site under testing:
        // google.com
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlContains(SUT));

        // Searching test phrase and matching if the list of results isn't empty
        searchPage.setTextInSearchField(TEST_SEARCH_PHRASE + '\n');
        driverWait().until(ExpectedConditions.urlContains(SUT + "/search"));
        driverWait().until(ExpectedConditions.visibilityOf(searchResultPage.getResultListAsElement()));
        assertFalse(searchResultPage.getResultsList().isEmpty(), "The list of results is empty!");
    }

}
