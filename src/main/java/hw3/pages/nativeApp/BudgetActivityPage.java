package hw3.pages.nativeApp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class describes the budget activity page
 */
public class BudgetActivityPage extends AbstractBasePage {

    private By actionBarBy = By.id(APP_PACKAGE_NAME + "action_bar");

    @FindBy(id = APP_PACKAGE_NAME + "action_bar")
    private WebElement actionBar;

    public BudgetActivityPage(AppiumDriver driver) {
        super(driver);
    }

    public By getActionBarBy() {
        return actionBarBy;
    }

    public String getPageTitle() {
        return actionBar.findElement(By.className("android.widget.TextView")).getText();
    }

}
