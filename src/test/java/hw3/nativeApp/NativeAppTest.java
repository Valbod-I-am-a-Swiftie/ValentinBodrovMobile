package hw3.nativeApp;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.Test;
import hw3.pages.nativeApp.BudgetActivityPage;
import hw3.pages.nativeApp.RegistrationPage;
import hw3.pages.nativeApp.SignInPage;
import hw3.setup.DriverSetup;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

/**
 * This test class describes the test of a native
 * application - EPAMTestApp
 */
public class NativeAppTest extends DriverSetup {

    private SignInPage signInPage;
    private RegistrationPage registrationPage;
    private BudgetActivityPage budgetActivityPage;

    private String TEST_EMAIL;
    private String TEST_USERNAME;
    private String TEST_PASSWORD;
    private String TEST_PAGE_TITLE;

    public NativeAppTest() throws IOException {
    }

    @Test(groups = {"android_native", "ios_native"})
    public void nativeAppTest() throws Exception {
        TEST_EMAIL = getProp("test_email");
        TEST_USERNAME = getProp("test_username");
        TEST_PASSWORD = getProp("test_password");
        TEST_PAGE_TITLE = getProp("test_title");

        this.signInPage = new SignInPage(driver());
        this.registrationPage = new RegistrationPage(driver());
        this.budgetActivityPage = new BudgetActivityPage(driver());

        // Clicking registration button for registration
        // of a new test user
        signInPage.goToRegistrationPage();

        // Setting all necessary data for test user
        // registration
        driverWait().until(ExpectedConditions.visibilityOf(registrationPage.getRegistrationEmailTextField()));
        registrationPage.setEmailTextField(TEST_EMAIL);
        registrationPage.setUsernameTextField(TEST_USERNAME);
        registrationPage.setPasswordTextField(TEST_PASSWORD);
        registrationPage.setConfirmPasswordTextField(TEST_PASSWORD);
        registrationPage.setConfirmSwitchOn();
        registrationPage.registerNewUser();

        // Signing in and going to Budget Activity Page
        driverWait().until(ExpectedConditions.visibilityOf(signInPage.getLoginEmailTextField()));
        signInPage.setTextLoginEmailTextField(TEST_EMAIL);
        signInPage.setTextPasswordTextField(TEST_PASSWORD);
        signInPage.signIn();

        // Checking if the page title matches to expected title
        switch (TEST_PLATFORM) {
            case "Android":
                driverWait().until(ExpectedConditions.presenceOfElementLocated(budgetActivityPage.getActionBarAndroidBy()));
                break;
            case "IOS":
                driverWait().until(ExpectedConditions.presenceOfElementLocated(budgetActivityPage.getActionBarIosBy()));
                break;
            default:
                throw new Exception("Unknown test platform");
        }

        assertEquals(budgetActivityPage.getPageTitle(TEST_PLATFORM), TEST_PAGE_TITLE,
                String.format("Expected %s pagetitle, but got %s",
                        TEST_PAGE_TITLE, budgetActivityPage.getPageTitle(TEST_PLATFORM)));
    }

    @AfterGroups(alwaysRun = true, groups = {"android_native", "ios_native"})
    public void tearDown() throws Exception {
        driver().quit();
    }

}
