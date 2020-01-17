package hw3.setup;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is a base class for properties
 * and set up classes
 */
public class TestProperties {
    private Properties currentProps = new Properties();

    /**
     * This method sets a file with property to enum
     * @param propertyFileType
     */
    protected void setPropertyFileName(PropertyFileType propertyFileType) {
        PropertyFileSingleton.FILE_NAME_INSTANCE.setFileName(propertyFileType.getFileType());
    }

    /**
     * This method loads properties from a file
     * @return
     * @throws IOException
     */
    private Properties getCurrentProps() throws IOException {
        FileInputStream in = new FileInputStream(
                String.format("%s/%s", System.getProperty("user.dir"),
                        PropertyFileSingleton.FILE_NAME_INSTANCE.getFileName()));
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    /**
     * This method is used for getting some properties
     * from a file
     * @param propKey
     * @return
     * @throws IOException
     */
    protected String getProp(String propKey) throws IOException {
        if (!currentProps.containsKey(propKey)) {
            currentProps = getCurrentProps();
        }
        return currentProps.getProperty(propKey, null);
    }
}
