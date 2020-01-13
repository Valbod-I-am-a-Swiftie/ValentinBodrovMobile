package hw2.nativeApp;

import hw2.setup.PropertyFileType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import hw2.pages.nativeApp.BudgetActivityPage;
import hw2.pages.nativeApp.RegistrationPage;
import hw2.pages.nativeApp.SignInPage;
import hw2.setup.DriverSetup;

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

    /**
     * This method sets all necessary data
     * for test completing
     * @throws Exception
     */
    @BeforeSuite(groups = {"native"})
    void setUpNative() throws Exception {
        setPropertyFileName(PropertyFileType.NATIVE);
        prepareDriver();

        TEST_EMAIL = getProp("test_email");
        TEST_USERNAME = getProp("test_username");
        TEST_PASSWORD = getProp("test_password");
        TEST_PAGE_TITLE = getProp("test_title");

        this.signInPage = new SignInPage(driver());
        this.registrationPage = new RegistrationPage(driver());
        this.budgetActivityPage = new BudgetActivityPage(driver());
    }

    @Test(groups = {"native"})
    public void nativeAppTest() throws Exception {
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
        registrationPage.registerNewUser();

        // Signing in and going to Budget Activity Page
        driverWait().until(ExpectedConditions.visibilityOf(signInPage.getLoginEmailTextField()));
        signInPage.setTextLoginEmailTextField(TEST_EMAIL);
        signInPage.setTextPasswordTextField(TEST_PASSWORD);
        signInPage.signIn();

        // Checking if the page title matches to expected title
        driverWait().until(ExpectedConditions.presenceOfElementLocated(budgetActivityPage.getActionBarBy()));
        assertEquals(budgetActivityPage.getPageTitle(), TEST_PAGE_TITLE,
                String.format("Expected %s pagetitle, but got %s",
                        TEST_PAGE_TITLE, budgetActivityPage.getPageTitle()));
    }

    /**
     * This method quits application under testing
     * @throws Exception
     */
    @AfterSuite(groups = {"native"})
    public void tearDown() throws Exception {
        driver().quit();
    }

}
