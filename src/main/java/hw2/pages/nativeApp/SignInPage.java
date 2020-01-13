package hw2.pages.nativeApp;

import hw2.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class describes the main page:
 * sign in page
 */
public class SignInPage extends AbstractBasePage {

    @FindBy(id = APP_PACKAGE_NAME + "register_button")
    private WebElement registerNewAccountButton;

    @FindBy(id = APP_PACKAGE_NAME + "login_email")
    private WebElement loginEmailTextField;

    @FindBy(id = APP_PACKAGE_NAME + "login_pwd")
    private WebElement loginPasswordTextField;

    @FindBy(id = APP_PACKAGE_NAME + "email_sign_in_button")
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
