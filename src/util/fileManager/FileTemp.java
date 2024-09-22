package util.fileManager;

import java.io.File;

public abstract class FileTemp<T> implements IFile<T>
{

    protected String filePath = "c:/tp-volaille";
    protected String fileName;
    protected File directory;
    protected File tempFile;

    public FileTemp(String filePath, String fileName) {
        this.filePath += filePath;
        this.fileName = fileName + "." + this.getExtension();
        this.directory = this.getDirectory();
    }

    private File getDirectory() {

        File dir = new File(this.filePath);
        if (!dir.exists()) {
            dir.mkdirs();//TODO try catch
        }

        return dir;
    }

    protected abstract String getExtension();
}
