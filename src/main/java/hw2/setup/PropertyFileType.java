package hw2.setup;

/**
 * This enum contains information about
 * types of properties
 */
public enum PropertyFileType {

    WEB("web.properties"),
    NATIVE("native.properties");

    String fileType;

    PropertyFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileType() {
        return this.fileType;
    }

}
