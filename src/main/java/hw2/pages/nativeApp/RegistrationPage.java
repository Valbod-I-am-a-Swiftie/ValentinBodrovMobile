package hw2.pages.nativeApp;

import hw2.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class describes the registration page:
 * here we can set all data for registration
 */
public class RegistrationPage extends AbstractBasePage {

    @FindBy(id = APP_PACKAGE_NAME + "registration_email")
    private WebElement registrationEmailTextField;

    @FindBy(id = APP_PACKAGE_NAME + "registration_username")
    private WebElement usernameTextField;

    @FindBy(id = APP_PACKAGE_NAME + "registration_password")
    private WebElement passwordTextField;

    @FindBy(id = APP_PACKAGE_NAME + "registration_confirm_password")
    private WebElement confirmPasswordTextField;

    @FindBy(id = APP_PACKAGE_NAME + "register_new_account_button")
    private WebElement registerButton;

    public RegistrationPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getRegistrationEmailTextField() {
        return registrationEmailTextField;
    }

    public void setEmailTextField(final String email) {
        registrationEmailTextField.sendKeys(email);
    }

    public void setUsernameTextField(final String username) {
        usernameTextField.sendKeys(username);
    }

    public void setPasswordTextField(final String password) {
        passwordTextField.sendKeys(password);
    }

    public void setConfirmPasswordTextField(final String password) {
        confirmPasswordTextField.sendKeys(password);
    }

    public void registerNewUser() {
        registerButton.click();
    }

}
