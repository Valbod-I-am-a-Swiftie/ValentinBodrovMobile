package hw3.api;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This singleton provides the access to token
 */
public class TokenReaderSingleton extends Properties {

    private static TokenReaderSingleton instance;

    public static TokenReaderSingleton getInstance() {
        if (instance == null) {
            instance = new TokenReaderSingleton();
            try {
                instance.load(new FileInputStream(
                        String.format("%s/%s", System.getProperty("user.dir"), "auth.api.properties")));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

}
