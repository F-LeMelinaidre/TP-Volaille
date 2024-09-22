package util.fileManager;

import java.io.IOException;

public interface IFile<T>
{
    void writeFile(T data) throws IOException;
    T readFile() throws IOException;

}
