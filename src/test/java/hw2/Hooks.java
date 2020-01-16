package hw2;

import hw2.setup.DriverSetup;
import hw2.setup.PropertyFileType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * This class describes and sets
 * the property file type and
 * starts driver preparing
 */
public class Hooks extends DriverSetup {

    @BeforeSuite(groups = {"native"})
    void setUpNative() throws Exception {
        setPropertyFileName(PropertyFileType.NATIVE);
        prepareDriver();
    }

    @BeforeSuite(groups = {"web"})
    void setUpWeb() throws Exception {
        setPropertyFileName(PropertyFileType.WEB);
        prepareDriver();
    }

    @AfterSuite(groups = {"native", "web"})
    public void tearDown() throws Exception {
        driver().quit();
    }
}
