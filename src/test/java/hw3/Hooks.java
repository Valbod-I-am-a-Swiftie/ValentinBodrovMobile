package hw3;

import hw3.setup.DriverSetup;
import hw3.setup.PropertyFileType;
import org.testng.annotations.BeforeSuite;

/**
 * This class describes and sets
 * the property file type and
 * starts driver preparing
 */
public class Hooks extends DriverSetup {

    /**
     * This method prepares driver for
     * manipulations with android native application
     *
     * @throws Exception
     */
    @BeforeSuite(groups = {"android_native"})
    void setUpAndroidNative() throws Exception {
        setPropertyFileName(PropertyFileType.ANDROID_NATIVE);
        prepareDriver();
    }

    /**
     * This method prepares driver for
     * manipulations with ios native application
     *
     * @throws Exception
     */
    @BeforeSuite(groups = {"ios_native"})
    void setUpIosNative() throws Exception {
        setPropertyFileName(PropertyFileType.IOS_NATIVE);
        prepareDriver();
    }

    /**
     * This method prepares driver for
     * manipulations with Android web application
     *
     * @throws Exception
     */
    @BeforeSuite(groups = {"android_web"})
    void setUpAndroidWeb() throws Exception {
        setPropertyFileName(PropertyFileType.ANDROID_WEB);
        prepareDriver();
    }

    /**
     * This method prepares driver for
     * manipulations with IOS web application
     *
     * @throws Exception
     */
    @BeforeSuite(groups = {"ios_web"})
    void setUpIosWeb() throws Exception {
        setPropertyFileName(PropertyFileType.IOS_WEB);
        prepareDriver();
    }
}
