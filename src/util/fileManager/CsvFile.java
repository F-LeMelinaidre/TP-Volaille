package util.fileManager;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvFile<T extends CsvSerializable> extends FileTemp<List<T>>
{
    protected static final String EXTENSION = "csv";
    private static final String DELIMITER = ",";
    private static final String SEPARATOR = "\n";
    private String header;

    public CsvFile(String fileName) {
        super("/csv", fileName);
    }


    @Override
    public void writeFile(List<T> data) throws IOException {

        try {

            File file = new File(this.directory, this.fileName);
            FileWriter csv = new FileWriter(file);

            try {
                // En-tête du csv
                csv.write(data.getFirst().headerForCsv());
                csv.write(SEPARATOR);

                // Données
                for (T value : data) {
                    csv.write(value.dataForCsv());
                    csv.write(SEPARATOR);
                }

                csv.flush();
                System.out.println("Les données ont été exportées");
            } finally {
                csv.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<T> readFile() throws IOException {
        return null;
    }

    @Override
    protected String getExtension() {
        return EXTENSION;
    }
}
