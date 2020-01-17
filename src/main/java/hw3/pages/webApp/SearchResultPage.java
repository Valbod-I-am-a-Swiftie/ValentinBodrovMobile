package hw3.pages.webApp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * This class describes the search result page
 */
public class SearchResultPage extends AbstractBasePage {

    @FindBy(xpath = ".//*[@id='rso']/div[@class='srg']/div")
    private List<WebElement> resultList;

    @FindBy(xpath = ".//*[@id='rso']/div[@class='srg']/div")
    private WebElement resultListAsElement;

    public SearchResultPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getResultListAsElement() {
        return resultListAsElement;
    }

    public List<WebElement> getResultsList() {
        return this.resultList;
    }
}
