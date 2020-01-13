package hw2.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * A base class for all pages
 * that are used in tests
 */
public class AbstractBasePage {

    protected AppiumDriver driver;

    protected static final String APP_PACKAGE_NAME = "platkovsky.alexey.epamtestapp:id/";

    protected AbstractBasePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
