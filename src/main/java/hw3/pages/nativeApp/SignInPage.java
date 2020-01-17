package hw3.pages.nativeApp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * This class describes the main page:
 * sign in page
 */
public class SignInPage extends AbstractBasePage {

    @FindAll({
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Register new account']"),
            @FindBy(id = APP_PACKAGE_NAME + "register_button")
    })
    private WebElement registerNewAccountButton;

    @FindAll({
            @FindBy(id = APP_PACKAGE_NAME + "login_email"),
            @FindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    })
    private WebElement loginEmailTextField;

    @FindAll({
            @FindBy(id = APP_PACKAGE_NAME + "login_pwd"),
            @FindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    })
    private WebElement loginPasswordTextField;

    @FindAll({
            @FindBy(id = APP_PACKAGE_NAME + "email_sign_in_button"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Sign In']")
    })
    private WebElement signInButton;

    public SignInPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getLoginEmailTextField() {
        return loginEmailTextField;
    }

    public void goToRegistrationPage() {
        registerNewAccountButton.click();
    }

    public void setTextLoginEmailTextField(final String loginEmail) {
        loginEmailTextField.sendKeys(loginEmail);
    }

    public void setTextPasswordTextField(final String password) {
        loginPasswordTextField.sendKeys(password);
    }

    public void signIn() {
        signInButton.click();
    }

}
