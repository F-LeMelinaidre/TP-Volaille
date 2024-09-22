package util.fileManager;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class BinarieFile<T> extends FileTemp<Map<String, T>>
{

    public BinarieFile(String fileName) {
        this.filePath += "/binarie";
        this.fileName = fileName;
        this.directory = new File(filePath);

        System.out.println(filePath);
    }

    @Override
    public void writeFile(Map<String, T> data) throws IOException {
        try {
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File file = new File(directory, this.fileName + ".bin");
            //Ouverture du flux de sortie
            FileOutputStream fos = new FileOutputStream(file);
            //Création du flux objet vers le flux de fichier
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            try {
                oos.writeObject(data);
                oos.flush();
                System.out.println("Les données ont été sérialisées");
            } finally {
                {
                    // fermeture du stream object
                    oos.close();
                    // fermeture du flux de sortie
                    fos.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, T> readFile() throws IOException {
        Map<String, T> data = new HashMap<String, T>();

        try {

            //ouverture du flux d'entrée
            FileInputStream fis = new FileInputStream(this.filePath + "/" + this.fileName + ".bin");
            //création du flux objet
            ObjectInputStream ois = new ObjectInputStream(fis);

            try {
                data = (Map<String, T>) ois.readObject();

            } finally {
                ois.close();
                fis.close();
            }


        } catch (IOException e) {

            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }

        return data;
    }
}
