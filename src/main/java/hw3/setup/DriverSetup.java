package hw3.setup;

import hw3.api.MobileCloudApi;
import hw3.api.TokenReaderSingleton;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

/**
 * This class sets all necessary properties
 * and variables for test running, e.g. driver
 * and wait
 */
public class DriverSetup extends TestProperties {
    private AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    private DesiredCapabilities capabilities;

    private String AUT;
    protected String SUT;
    private String TEST_PLATFORM;
    private String BROWSER;
    private String DRIVER;
    private String UDID;
    private String APP_PACKAGE;
    private String APP_ACTIVITY;
    private String TOKEN;

    /**
     * This method prepares driver for tests
     * and sets all desired capabilities for
     * Appium server
     * @throws Exception
     */
    protected void prepareDriver() throws Exception {
        AUT = getProp("aut");
        SUT = getProp("sut") == null ? null : "https://" + getProp("sut");
        BROWSER = getProp("browser");
        TEST_PLATFORM = getProp("platform");
        DRIVER = getProp("driver");
        UDID = getProp("udid");
        APP_PACKAGE = getProp("app_package");
        APP_ACTIVITY = getProp("app_activity");
        TOKEN = TokenReaderSingleton.getInstance().getProperty("token");

        DRIVER = DRIVER.replace("***", TOKEN);

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.UDID, UDID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);

        if(AUT != null && SUT == null) {
            File app = new File(getProp("aut"));
            MobileCloudApi
                    .with()
                    .takeInUse(getProp("udid"));
            MobileCloudApi
                    .with()
                    .serial(getProp("udid"))
                    .file(app)
                    .installApp(getProp("udid"));
            capabilities.setCapability("appPackage", APP_PACKAGE);
            capabilities.setCapability("appActivity", APP_ACTIVITY);
        } else if (SUT != null && AUT == null) {
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, BROWSER);
        } else {
            throw new Exception("Unclear type of mobile app");
        }
        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }
    }

    /**
     * This method is used for getting a driver
     * @return
     * @throws Exception
     */
    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) {
            prepareDriver();
        }
        return driverSingle;
    }

    /**
     * This method is used for getting a wait
     * @return
     * @throws Exception
     */
    protected WebDriverWait driverWait() throws Exception {
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 20);
        }
        return waitSingle;
    }

}
