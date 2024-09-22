package util.fileManager;

import java.io.File;

public abstract class FileTemp<T> implements IFile<T>
{

    protected String filePath = "c:/tp-volaille";
    protected String fileName;
    protected File directory;


}
