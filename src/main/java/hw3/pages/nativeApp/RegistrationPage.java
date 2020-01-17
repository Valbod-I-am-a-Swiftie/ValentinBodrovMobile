package hw3.pages.nativeApp;

import hw3.pages.AbstractBasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

/**
 * This class describes the registration page:
 * here we can set all data for registration
 */
public class RegistrationPage extends AbstractBasePage {

    @FindAll({
            @FindBy(id = APP_PACKAGE_NAME + "registration_email"),
            @FindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    })
    private WebElement registrationEmailTextField;

    @FindAll({
            @FindBy(id = APP_PACKAGE_NAME + "registration_username"),
            @FindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    })
    private WebElement usernameTextField;

    @FindAll({
            @FindBy(id = APP_PACKAGE_NAME + "registration_password"),
            @FindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    })
    private WebElement passwordTextField;

    @FindAll({
            @FindBy(id = APP_PACKAGE_NAME + "registration_confirm_password"),
            @FindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    })
    private WebElement confirmPasswordTextField;

    @FindAll({
            @FindBy(xpath = "//*[@text='I read agreaments and agree wit it']"),
            @FindBy(xpath = "//XCUIElementTypeSwitch")
    })
    private WebElement confirmSwitch;

    @FindAll({
            @FindBy(id = APP_PACKAGE_NAME + "register_new_account_button"),
            @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Register new account']")
    })
    private WebElement registerButton;

    public RegistrationPage(AppiumDriver driver) {
        super(driver);
    }

    public WebElement getRegistrationEmailTextField() {
        return registrationEmailTextField;
    }

    public WebElement getRegisterButton() {
        return registerButton;
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

    public void setConfirmSwitchOn() {
        confirmSwitch.click();
    }

    public void registerNewUser() {
        registerButton.click();
    }

}
