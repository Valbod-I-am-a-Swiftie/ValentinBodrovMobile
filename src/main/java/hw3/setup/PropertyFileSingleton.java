package hw3.setup;

/**
 * This enum contains information about
 * file with properties
 */
public enum PropertyFileSingleton {

    FILE_NAME_INSTANCE;

    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
