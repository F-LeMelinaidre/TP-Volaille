package util.fileManager;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class CsvFile<T> extends FileTemp<Map<String, T>>
{
    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";
    private final String[] header;

    public CsvFile(String fileName, String[] header) {

        super("/csv", fileName);
        this.header = header;

    }


    @Override
    public void writeFile(Map<String, T> data) throws IOException {

    }

    @Override
    public Map<String, T> readFile() throws IOException {
        return Map.of();
    }
}
