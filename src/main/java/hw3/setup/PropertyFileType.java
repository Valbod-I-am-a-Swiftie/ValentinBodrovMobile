package hw3.setup;

/**
 * This enum contains information about
 * types of properties
 */
public enum PropertyFileType {

    ANDROID_NATIVE("android.native.properties"),
    IOS_NATIVE("ios.native.properties"),
    ANDROID_WEB("android.web.properties"),
    IOS_WEB("ios.web.properties");

    String fileType;

    PropertyFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return this.fileType;
    }

}
