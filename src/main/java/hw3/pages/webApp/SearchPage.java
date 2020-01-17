package hw3.pages.webApp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class describes the main page: search page
 * Here we can set search phrase
 */
public class SearchPage extends AbstractBasePage {

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public SearchPage(AppiumDriver driver) {
        super(driver);
    }

    public void setTextInSearchField(String queryPhrase) {
        searchField.sendKeys(queryPhrase);
        searchField.submit();
    }
}
