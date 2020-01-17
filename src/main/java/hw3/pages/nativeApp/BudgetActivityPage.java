package hw3.pages.nativeApp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * This class describes the budget activity page
 */
public class BudgetActivityPage extends AbstractBasePage {

    private By actionBarAndroidBy = By.id(APP_PACKAGE_NAME + "action_bar");
    private By actionBarIosBy = By.xpath("//XCUIElementTypeOther[@label='Budget']");

    @FindAll({
            @FindBy(id = APP_PACKAGE_NAME + "action_bar"),
            @FindBy(xpath = "//XCUIElementTypeOther[@label='Budget']")
    })
    private WebElement actionBar;

    public BudgetActivityPage(AppiumDriver driver) {
        super(driver);
    }

    public By getActionBarAndroidBy() {
        return actionBarAndroidBy;
    }

    public By getActionBarIosBy() {
        return actionBarIosBy;
    }

    // There was some difficult moments with IOS,
    // it doesn't have android.widget.TextView, so I
    // added this switch
    public String getPageTitle(String os) throws Exception {
        switch (os) {
            case "Android":
                return actionBar.findElement(By.className("android.widget.TextView")).getText();
            case "IOS":
                return actionBar.getText();
            default:
                throw new Exception("Unknown mobile platform");
        }
    }

}
