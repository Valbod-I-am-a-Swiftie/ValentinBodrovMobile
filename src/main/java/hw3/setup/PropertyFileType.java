package hw3.setup;

/**
 * This enum contains information about
 * types of properties
 */
public enum PropertyFileType {

    IOS_WEB("ios.web.properties"),
    ANDROID_NATIVE("android.native.properties");

    String fileType;

    PropertyFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return this.fileType;
    }

}
